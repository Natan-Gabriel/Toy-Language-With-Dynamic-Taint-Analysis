declare namespace codegen = "http://www2.in.tum.de";

declare function codegen:codeL($expr as node(),$env as node()*) 
as xs:string {
for $var in $env
where name($var)=$expr
return $var
};

declare function codegen:codeC($expr as node(),$env as node()*) 
as xs:string {
let $variant := $expr/@variant
return switch($variant)
   case "0" return "CONST " || $expr/c || "&#10;"
   case "1" return codegen:codeC($expr/c,$env) 
   case "2" return codegen:codeR($expr/expr[1],$env) || codegen:codeR($expr/expr[2],$env) || $expr/op ||"&#10;"
   case "3" return codegen:codeR($expr/e,$env) || $expr/op ||"&#10;"
   case "4" return codegen:codeC($expr/expr[1],$env) || codegen:codeC($expr/expr[2],$env) || $expr/op ||"&#10;"
   default return "error"
};

declare function codegen:codeR($expr as node(),$env as node()*) 
as xs:string {
let $variant := $expr/@variant
return switch($variant)
   case "0" return "LOAD " || codegen:codeL($expr/identifier,$env) || "&#10;"
   case "1" return "CONST " || $expr/constant || "&#10;"
   case "2" return codegen:codeR($expr/e,$env) 
   case "3" return codegen:codeR($expr/e,$env) || $expr/op ||"&#10;"
   case "4" return codegen:codeR($expr/expr[1],$env) || codegen:codeR($expr/expr[2],$env) || $expr/op ||"&#10;"
   default return "error"
};

declare function codegen:assignment($stmt as node(),$env as node()*) 
as xs:string {
let $rhs := $stmt/expr
let $lhs := $stmt/lhs
return codegen:codeR($rhs,$env) || "STORE " || codegen:codeL($lhs,$env) || "&#10;"
(: return codegen:codeR($rhs,$env) || "STORE " || codegen:codeL($lhs,$env) || "&#10;" :)
};

declare function codegen:read($stmt as node(),$env as node()*) 
as xs:string {
let $rhs := $stmt/expr
let $lhs := $stmt/lhs
return "READ &#10;STORE " || codegen:codeL($lhs,$env) || "&#10;"
};

declare function codegen:write($stmt as node(),$env as node()*) 
as xs:string {
let $expr := $stmt/expr
return codegen:codeR($expr,$env) || "WRITE &#10;"
};

declare function codegen:while($stmt as node(),$env as node()*) 
as xs:string {
let $cond := $stmt/cond
let $stmt := $stmt/stmt
let $ctx := count($stmt/preceding::*)
return "A"|| $ctx || ": "|| codegen:codeC($cond,$env) || "FJUMP B"|| $ctx || "&#10;" || codegen:code($stmt,$env) || "JUMP A"|| $ctx || "&#10;B"|| $ctx || ": " 
};

declare function codegen:if($stmt as node(),$env as node()*) 
as xs:string {
let $cond := $stmt/cond
let $stmt := $stmt/stmt
let $ctx := count($stmt/preceding::*)
return  codegen:codeC($cond,$env) || "FJUMP A"|| $ctx || "&#10;" || codegen:code($stmt,$env) || "A"|| $ctx || ": "
};

declare function codegen:ifelse($stmt as node(),$env as node()*) 
as xs:string {
let $cond := $stmt/cond
let $stm := $stmt/stmt
let $ctx := count($stmt/preceding::*)
return codegen:codeC($cond,$env) || "FJUMP A"|| $ctx || "&#10;" ||codegen:code($stm[1],$env) || "JUMP B"|| $ctx || "&#10;A"|| $ctx || ": " ||codegen:code($stm[2],$env)|| "B"|| $ctx || ": "
};


declare function codegen:code($stmt as node(),$env)
as xs:string
{
let $variant := $stmt/@variant
return switch($variant)
   case "0" return "n/a empty&#10;"
   (: composed STMT :)
   case "1" return fn:fold-right($stmt/stmtlist/stmt,"",function ($stm,$acc) { if (fn:empty($stm)) then "" else $acc || codegen:code($stm,$env) })
   case "2" return codegen:assignment($stmt,$env)
   case "3" return codegen:read($stmt,$env)
   (: read with message! :)
   case "4" return codegen:read($stmt,$env)
   case "5" return codegen:write($stmt,$env)
   case "6" return "n/a: write(string)&#10;"
   case "7" return codegen:if($stmt,$env)
   case "8" return codegen:ifelse($stmt,$env)
   (: WHILE :)
   case "9" return codegen:while($stmt,$env)
   default return "error" || $stmt
};


declare function codegen:env($decllist as node())
as node()*
{
  for $id at $ident in $decllist//identifier
  return element { xs:QName($id) } {
      xs:string($ident) 
      }
};


let $program := doc('output.xml')//program
let $stmts := $program/stmtlist
let $env := codegen:env($program/decllist)
let $alloc := count($env)
return "ALLOC "|| $alloc || "&#10;" || fold-right($stmts/stmt,"",function($stmt,$acc) { if (empty($stmt)) then "" else codegen:code($stmt,$env)|| $acc  }) || "HALT&#10;"
