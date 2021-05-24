grammar MyGrammar;
prog: block ;

block: ( stat? NEWLINE )* ;

stat:   REPEAT repetitions block ENDREPEAT   #repeat
    |   ID '=' expression		#assign
	|   PRINT ID   		        #print
    |   READ ID   		        #read

    ;

expression
    : value                        #valueExpr
    | expression MULTIPLY value    #mulExpression
    | expression DIVIDE  value     #divExpression
    | expression SUBTRACT expression    #subExpression
    | expression ADD expression         #addExpression
    ;

repetitions
    : repeatValue
    ;

repeatValue
    : ID
    | INT
    ;

function: FUNCTION fparam fblock ENDFUNCTION
;

fparam: ID
;

fblock: ( stat? NEWLINE )*
;

value
    : '(' expression ')'                #parensExpression
        | TOINT value		            #toint
        | TOREAL value		            #toreal
        | INT                               #int
        | REAL                              #real
        | ID                                #variable
        ;

PRINT    : 'drukuj' ;
READ:	'czytaj' ;

REPEAT: 'powtorz'   ;

ENDREPEAT: 'koniecpowtorz';

FUNCTION: 'funkcja'
;

ENDFUNCTION:	'koniecfunkcja'
;

TOINT: '(int)'
    ;

TOREAL: '(real)'
    ;

    STRING :  '"' ( ~('\\'|'"') )* '"';

    ID       : ('a'..'z'|'A'..'Z')+ ;

    REAL     : '0'..'9'+'.''0'..'9'+ ;

    INT      : ('0'..'9')+ ;

MULTIPLY : '*' ;
DIVIDE   : '/' ;
SUBTRACT : '-' ;
ADD      : '+' ;

NEWLINE  : '\r'? '\n' ;

WS: [ \t\r\n]+ -> skip ;
