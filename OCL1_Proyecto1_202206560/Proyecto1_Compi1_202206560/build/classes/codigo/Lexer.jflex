// ------------  Paquete e importaciones ------------
package codigo; 

import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares 

entero = [0-9]+
L=[a-zA-Z_]+
espacio=[ ,\t,\r]+
comentario = []
cadena = \"[^\"\n]*\"
decimal = [0-9]+(\.[0-9]+)?
identificador = [a-zA-Z_][a-zA-Z_0-9]*

%%
// ------------  Reglas Lexicas -------------------
"("         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"         {System.out.println("Token: " + yytext() + " Línea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}

"*"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.POR, yycolumn, yyline, yytext());}
"+"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.MAS, yycolumn, yyline, yytext());}

"mostrar"   {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MOSTRAR, yycolumn, yyline, yytext());}

{entero}  {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }

// verdadera Gramática

"PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_ENDPROGRAM, yycolumn, yyline, yytext());}
"var:double::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_VAR_DOUBLE, yycolumn, yyline, yytext());}
"var:char[]::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_VAR_CHAR, yycolumn, yyline, yytext());}
"<-" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.ASIGNACION, yycolumn, yyline, yytext());}
"end;" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.FIN_DECLARACION, yycolumn, yyline, yytext());}

{cadena} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{decimal} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{identificador} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}




comentario {}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.              	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

