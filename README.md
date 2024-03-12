# Manual Técnico
## José Daniel Lorenzana Medina - 202206560

### 1. Información del Proyecto

- **Nombre del Proyecto:** Sistema de Gestión de Archivos y Ejecución de Código.
- **Descripción:** El Sistema de Gestión de Archivos y Ejecución de Código es una aplicación diseñada para permitir a los usuarios cargar archivos de código fuente, analizar su sintaxis y ejecutar el código contenido en ellos. La aplicación está escrita en Java y utiliza Flex para el análisis léxico y Cup para el análisis sintáctico.
- **Autor:** José Daniel Lorenzana Medina
- **Fecha de Creación:** 11/03/2024
- **Lenguaje de Programación:** Java.
- **Herramientas Utilizadas:** Flex para el análisis léxico y Cup para el análisis sintáctico.
- **Entorno de Desarrollo Integrado (IDE):** NetBeans.

### 2. Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **`Lexer.flex`:** Este archivo contiene las especificaciones del analizador léxico, escrito en Flex. Define patrones para identificar tokens en el código fuente.
```java
"console" {
    System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); 
    tokens.add(new Token(yytext(), yyline, yycolumn, "R_CONSOLE")); 
    return new Symbol(sym.R_CONSOLE, yycolumn, yyline, yytext());
}

"print" {
    System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); 
    tokens.add(new Token(yytext(), yyline, yycolumn, "R_PRINT")); 
    return new Symbol(sym.R_PRINT, yycolumn, yyline, yytext());
}

"column" {
    System.out.println("Token: " + yytext() + " Linea: " + yyline + " Columna: " + yycolumn); 
    tokens.add(new Token(yytext(), yyline, yycolumn, "R_COLUMN")); 
    return new Symbol(sym.R_COLUMN, yycolumn, yyline, yytext());
}
```
- **`Parser.cup`:** Este archivo contiene las especificaciones del analizador sintáctico, escrito en Cup. Define la gramática del lenguaje y las reglas para construir el árbol de análisis.
```java
lista_instr ::= lista_instr instruccion
    | instruccion
;

instruccion ::= mostrar
    | declaracion
    | asignacion
    | declaracion_arreglo
    | console_print
    | console_column
    | graficacion
    | graficacionPie
    | graficacionLine
    | histograma
;

mostrar ::= R_MOSTRAR PARENTESIS_A expresion:val PARENTESIS_C PUNTOYCOMA   {: codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.mostrar(val.toString()); :}
;

expresion ::= expresion:a MAS expresion:b       {: RESULT = (Double)a + (Double)b; :}
    | expresion:a POR expresion:b               {: RESULT = (Double)a * (Double)b; :}
    | ENTERO:val                                {: RESULT = Double.parseDouble(val.toString()); :}
    | DECIMAL:val                               {: RESULT = Double.parseDouble(val.toString()); :}
    | CADENA:val                                {: RESULT = val.toString(); :}
    | IDENTIFICADOR:val                         {: RESULT = func.Funcion.obtenerValor(val.toString()); :}
    | IDENTIFICADOR_ARREGLO:val                 {: RESULT = func.Funcion.obtenerValor(val.toString()); :}
    | suma:val                                  {: RESULT = val; :}
    | resta:val                                 {: RESULT = val; :}
    | multi:val                                 {: RESULT = val; :}
    | division:val                              {: RESULT = val; :}
    | modulo:val                                {: RESULT = val; :}
    | estadistica: val                                {: RESULT = val; :}
;
```
- **`Lexer.java`:** Clase generada por Flex que implementa el analizador léxico. Se encarga de analizar el código fuente y generar una secuencia de tokens.
- **`Parser.java`:** Clase generada por Cup que implementa el analizador sintáctico. Se encarga de construir el árbol de análisis sintáctico a partir de la secuencia de tokens generada por el analizador léxico.
- **`Main.java`:** Clase principal que contiene el punto de entrada del programa y maneja la lógica principal del sistema. Se encarga de interactuar con los analizadores léxico y sintáctico, cargar archivos, ejecutar el código y mostrar resultados.
- **`Analizar.java`:** Clase que representa un archivo en el sistema. Contiene métodos para leer y escribir el contenido de un archivo.
- **`Analizadores.java`:** Clase que ejecuta el código analizado por el analizador léxico y sintáctico. Se encarga de interpretar y ejecutar las instrucciones del programa.

### 3. Funcionamiento del Sistema

El sistema funciona de la siguiente manera:

1. El usuario inicia la aplicación y accede a la interfaz de usuario.
2. Desde la interfaz de usuario, el usuario puede cargar un archivo de código fuente.
3. El archivo se pasa al analizador léxico (`Lexer.java`), que escanea el código y genera una secuencia de tokens.
4. La secuencia de tokens se pasa al analizador sintáctico (`Parser.java`), que verifica la estructura gramatical del código y construye el árbol de análisis sintáctico.
5. Si el código es válido, se ejecuta utilizando la clase `Analizar.java`.
6. Durante la ejecución, se pueden mostrar mensajes de salida y errores en la consola.
7. Los resultados de la ejecución se muestran al usuario a través de la interfaz de usuario.

### 4. Métodos y Funciones Importantes

- **Funciones y Métodos Generados por Flex y Cup:** Estas funciones son generadas automáticamente por las herramientas Flex y Cup según las reglas y especificaciones definidas en `Lexer.flex` y `Parser.cup`. Son esenciales para el análisis léxico y sintáctico del código fuente.

- **Métodos en la Clase `Main.java`:** Esta clase contiene métodos para interactuar con los analizadores léxico y sintáctico, cargar archivos, ejecutar el código y mostrar resultados. Es la clase principal que maneja la lógica del sistema.

- **Métodos en la Clase `Analizar.java`:** Esta clase contiene métodos para leer y escribir el contenido de un archivo. Es utilizada para cargar archivos de código fuente desde el sistema de archivos.

- **Métodos en la Clase `Analizadores.java`:** Esta clase contiene métodos para ejecutar el código analizado por los analizadores léxico y sintáctico. Es responsable de interpretar y ejecutar las instrucciones del programa.

### 5. Mantenimiento Futuro

Para realizar el mantenimiento futuro del sistema, se recomienda:

- Familiarizarse con el código generado por Flex y Cup, así como con la estructura del proyecto en general.
- Documentar cualquier cambio o nueva funcionalidad agregada.
- Realizar pruebas exhaustivas para garantizar el correcto funcionamiento del sistema después de realizar modificaciones.
- Mantener actualizadas las herramientas Flex y Cup, así como cualquier biblioteca o dependencia utilizada en el proyecto.
- Monitorear y corregir posibles problemas de rendimiento o seguridad.
