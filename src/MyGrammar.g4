grammar MyGrammar;

prog: ( stat? NEWLINE )* ;

stat:   ID '=' expression		#assign
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

TOINT: '(int)'
    ;

TOREAL: '(real)'
    ;
    ID       : ('a'..'z'|'A'..'Z')+ ;

    REAL     : '0'..'9'+'.''0'..'9'+ ;
    INT      : ('0'..'9')+ ;

MULTIPLY : '*' ;
DIVIDE   : '/' ;
SUBTRACT : '-' ;
ADD      : '+' ;

NEWLINE  : '\r'? '\n' ;

WS: [ \t\r\n]+ -> skip ;
