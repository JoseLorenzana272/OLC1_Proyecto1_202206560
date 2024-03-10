// ------------  Paquete e importaciones ------------
package codigo; 

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;
    

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
    public static List<Token> tokens = new ArrayList<>();
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
"console" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_CONSOLE")); return new Symbol(sym.R_CONSOLE, yycolumn, yyline, yytext());}
"print"     {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_PRINT")); return new Symbol(sym.R_PRINT, yycolumn, yyline, yytext());}
"column"    {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_COLUMN")); return new Symbol(sym.R_COLUMN, yycolumn, yyline, yytext());}
"sum" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_SUM")); return new Symbol(sym.R_SUM, yycolumn, yyline, yytext());}
"res" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_RES")); return new Symbol(sym.R_RES, yycolumn, yyline, yytext());}
"mul" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MUL")); return new Symbol(sym.R_MUL, yycolumn, yyline, yytext());}
"div" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_DIV")); return new Symbol(sym.R_DIV, yycolumn, yyline, yytext());}
"mod" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MOD")); return new Symbol(sym.R_MOD, yycolumn, yyline, yytext());}
"Media" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MEDIA")); return new Symbol(sym.R_MEDIA, yycolumn, yyline, yytext());}
"Mediana" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MEDIANA")); return new Symbol(sym.R_MEDIANA, yycolumn, yyline, yytext());}
"Moda" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MODA")); return new Symbol(sym.R_MODA, yycolumn, yyline, yytext());}
"Varianza" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_VARIANZA")); return new Symbol(sym.R_VARIANZA, yycolumn, yyline, yytext());}
"Max" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MAX")); return new Symbol(sym.R_MAX, yycolumn, yyline, yytext());}
"Min" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MIN")); return new Symbol(sym.R_MIN, yycolumn, yyline, yytext());}

//GRAFICAS
"graphBar" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "GRAPHBAR")); return new Symbol(sym.GRAPHBAR, yycolumn, yyline, yytext());}
"titulo" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "TITULO")); return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
"ejeX" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EJEX")); return new Symbol(sym.EJEX, yycolumn, yyline, yytext());}
"ejeY" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EJEY")); return new Symbol(sym.EJEY, yycolumn, yyline, yytext());}
"tituloX" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "TITULOX")); return new Symbol(sym.TITULOX, yycolumn, yyline, yytext());}
"tituloY" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "TITULOY")); return new Symbol(sym.TITULOY, yycolumn, yyline, yytext());}
"EXEC graphBar" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EXEC_GRAPHBAR")); return new Symbol(sym.EXEC_GRAPHBAR, yycolumn, yyline, yytext());}
"graphPie" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "GRAPHPIE")); return new Symbol(sym.GRAPHPIE, yycolumn, yyline, yytext());}
"EXEC graphPie" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EXEC_GRAPHPIE")); return new Symbol(sym.EXEC_GRAPHPIE, yycolumn, yyline, yytext());}
"label" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "LABEL")); return new Symbol(sym.LABEL, yycolumn, yyline, yytext());}
"values" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "VALUES")); return new Symbol(sym.VALUES, yycolumn, yyline, yytext());}
"graphLine" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "GRAPHLINE")); return new Symbol(sym.GRAPHLINE, yycolumn, yyline, yytext());}
"EXEC graphLine" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EXEC_GRAPHLINE")); return new Symbol(sym.EXEC_GRAPHLINE, yycolumn, yyline, yytext());}
"Histogram" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "HISTOGRAM")); return new Symbol(sym.HISTOGRAM, yycolumn, yyline, yytext());}
"EXEC Histogram" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "EXEC_HISTOGRAM")); return new Symbol(sym.EXEC_HISTOGRAM, yycolumn, yyline, yytext());}


"("         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "PARENTESIS_A")); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "PARENTESIS_C")); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"         {System.out.println("Token: " + yytext() + " Línea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "PUNTOYCOMA")); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"*"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "POR")); return new Symbol(sym.POR, yycolumn, yyline, yytext());}
"+"         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "MAS")); return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
"="         {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "IGUAL")); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}

"mostrar"   {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_MOSTRAR")); return new Symbol(sym.R_MOSTRAR, yycolumn, yyline, yytext());}

{entero}  {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "ENTERO")); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }

// verdadera Gramática

"PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_PROGRAM")); return new Symbol(sym.R_PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_ENDPROGRAM")); return new Symbol(sym.R_ENDPROGRAM, yycolumn, yyline, yytext());}

//VARIABLES QUE SI FUNCIONAN
"var" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_VAR")); return new Symbol(sym.R_VAR, yycolumn, yyline, yytext());}
":" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "COLLON")); return new Symbol(sym.COLLON, yycolumn, yyline, yytext());}
"::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "DOUBLE_COLLON")); return new Symbol(sym.DOUBLE_COLLON, yycolumn, yyline, yytext());}
"double" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_DOUBLE")); return new Symbol(sym.R_DOUBLE, yycolumn, yyline, yytext());}
"char[]" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_CHAR")); return new Symbol(sym.R_CHAR, yycolumn, yyline, yytext());}
"<-" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "ASIGNACION")); return new Symbol(sym.ASIGNACION, yycolumn, yyline, yytext());}
"->" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "FLECHA")); return new Symbol(sym.FLECHA, yycolumn, yyline, yytext());}
"end" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "FIN_DECLARACION")); return new Symbol(sym.FIN_DECLARACION, yycolumn, yyline, yytext());}


{cadena} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "CADENA")); return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{decimal} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "DECIMAL")); return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{identificador} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "IDENTIFICADOR")); return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}

//ARREGLOS
"arr:double::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_ARR_DOUBLE")); return new Symbol(sym.R_ARR_DOUBLE, yycolumn, yyline, yytext());}
"arr:char[]::" {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "R_ARR_CHAR")); return new Symbol(sym.R_ARR_CHAR, yycolumn, yyline, yytext());}
{identificador_arreglo} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "IDENTIFICADOR_ARREGLO")); return new Symbol(sym.IDENTIFICADOR_ARREGLO, yycolumn, yyline, yytext());}
{lista_valores} {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "LISTA_VALORES")); return new Symbol(sym.LISTA_VALORES, yycolumn, yyline, yytext());}

//ARREGLOS QUE SI SIRVEN 

//Operaciones

"," {System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); tokens.add(new Token(yytext(), yyline, yycolumn, "COMMA")); return new Symbol(sym.COMMA, yycolumn, yyline, yytext());}

comentario {}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.              	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

