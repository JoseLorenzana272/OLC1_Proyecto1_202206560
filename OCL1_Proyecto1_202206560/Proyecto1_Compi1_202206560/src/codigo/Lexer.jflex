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
//listas
lista_valores = \[[^\]]*\]
identificador_arreglo = @[a-zA-Z_][a-zA-Z_0-9]*

%%
// ------------  Reglas Lexicas -------------------

"sum" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_SUM, yycolumn, yyline, yytext());}
"res" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_RES, yycolumn, yyline, yytext());}
"mul" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MUL, yycolumn, yyline, yytext());}
"div" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_DIV, yycolumn, yyline, yytext());}
"mod" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MOD, yycolumn, yyline, yytext());}
"Media" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MEDIA, yycolumn, yyline, yytext());}
"Mediana" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MEDIANA, yycolumn, yyline, yytext());}
"Moda" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MODA, yycolumn, yyline, yytext());}
"Varianza" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_VARIANZA, yycolumn, yyline, yytext());}
"Max" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MAX, yycolumn, yyline, yytext());}
"Min" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MIN, yycolumn, yyline, yytext());}
"console" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_CONSOLE, yycolumn, yyline, yytext());}
"print" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_PRINT, yycolumn, yyline, yytext());}

"("         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"         {System.out.println("Token: " + yytext() + " Línea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"*"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.POR, yycolumn, yyline, yytext());}
"+"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
"="         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}

"mostrar"   {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_MOSTRAR, yycolumn, yyline, yytext());}

{entero}  {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }

// verdadera Gramática

"PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_ENDPROGRAM, yycolumn, yyline, yytext());}

//VARIABLES QUE SI FUNCIONAN
"var" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_VAR, yycolumn, yyline, yytext());}
":" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.COLLON, yycolumn, yyline, yytext());}
"::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.DOUBLE_COLLON, yycolumn, yyline, yytext());}
"double" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_DOUBLE, yycolumn, yyline, yytext());}
"char[]" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_CHAR, yycolumn, yyline, yytext());}
"<-" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.ASIGNACION, yycolumn, yyline, yytext());}
"end" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.FIN_DECLARACION, yycolumn, yyline, yytext());}


{cadena} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{decimal} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{identificador} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}

//ARREGLOS
"arr:double::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_ARR_DOUBLE, yycolumn, yyline, yytext());}
"arr:char[]::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.R_ARR_CHAR, yycolumn, yyline, yytext());}
{identificador_arreglo} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.IDENTIFICADOR_ARREGLO, yycolumn, yyline, yytext());}
{lista_valores} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.LISTA_VALORES, yycolumn, yyline, yytext());}

//ARREGLOS QUE SI SIRVEN 

//Operaciones

"," {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); return new Symbol(sym.COMMA, yycolumn, yyline, yytext());}

comentario {}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.              	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

