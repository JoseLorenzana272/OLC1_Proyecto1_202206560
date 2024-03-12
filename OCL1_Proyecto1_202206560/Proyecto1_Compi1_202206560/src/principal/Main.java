/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URI;


/**
 *
 * @author PERSONAL
 */
public class Main {
    
    public static class Token {
        public String type;
        public String value;
        public int line;
        public int column;

        public Token(String type, String value, int line, int column) {
            this.type = type;
            this.value = value;
            this.line = line;
            this.column = column;
        }
    }
    
    
    public static void main(String[] args) {
        
        analizadores("src/codigo/", "Lexer.jflex", "Parser.cup");
        
        String entrada = """
                         PROGRAM
                         	
                         	var:double:: notaAprobar <- 61 end;
                         	var:char[]:: labelAprobar <- "Nota Minima" end;
                         	! Esto pato peo no se si funciona queee?
                         	$
                         	arr:double:: @notas <- [notaAprobar, MUL(5, 0.45), DIV(100, 50)] end;
                         	arr:char[]:: @labels <- [labelAprobar, "P1", "P2"] end;
                         	var:double:: med1 <- Media([1, 2, SUM(3, 4), 4, 1]) end;
                         	var:double:: mitad <- DIV( SUM(Max(@notas), Min(@notas) ), 2) end;
                                console::print = med1, mitad end;
                                arr:double:: @perro <- [5, 21, 41, 45] end;
                                arr:char[]:: @nose <- [labelAprobar, "P1", "P2", "P3"] end;
                         	var:char[]:: titulo1 <- "Titulo histograma" end;
                         	console::column = "test" -> [10, 15.5, 61.1] end;
                         	console::column = "Notas" -> @notas end;
                                console::column = "SazoGallo" -> [1, 2, 3, SUM(4,5)] end;
                         	console::column = titulo1 -> @notas end;
                                <! Esto es un comentario
                                Multilínea !>
                         	console::print = "Media", "Mediana", "Moda", "Varianza", "Max", "Min" end;
                         	console::print = Media(@notas), Mediana(@notas), Moda(@notas), Varianza(@notas), Max(@notas), Min(@notas) end;
                         	console::print = "Hola Mundo", MOD(10, 9), notaAprobar, labelAprobar end;
                         	
                    %
                         ¡
                         	
                         	var:double:: gb1 <- 61 end;
                         	var:char[]:: gbt <- "Datos" end;
                         	
                         	graphBar(
                                                titulo::char[] = "Mario" end;
                                                ejeX::char[] = ["1 Parcial", "2 parcial", "3 parcial", "Final"] end;
                                                ejeY::double = [MUL(2,9), SUM(20, 21), 70, 4] end;
                                                ! funcionaaa???
                                		tituloX::char[] = "Actividades" end;
                                		tituloY::char[] = gbt end;
                                		EXEC graphBar end;
                                	) end;
                         
                                graphPie(

                                                label::char[] = ["Uno", "Dos", "Tres", "Cuatro"] end;
                                                values::double = [5, 50, 30, 20] end;
                                                titulo::char[] = gbt end;	
                                                <! Más que nunca
                                                                                        Un corazón !>	
                                                EXEC graphPie end;
                         	) end;
                         
                         
                         
                         graphLine(
                         	
                         		titulo::char[] = "Gráfica de Línea" end;
                         		ejeX::char[] = @labels end;
                         		ejeY::double = @notas end;
                         		tituloX::char[] = "Actividades" end;
                         		tituloY::char[] = "Notas" end;
                         		EXEC graphLine end;
                         	) end;
                         
                         Histogram(
                         		titulo::char[] = titulo1 end;
                         		values::double = [2,2,3,5,5,7,8] end;
                         		EXEC Histogram end;
                         	) end;

                         
                         END PROGRAM
                         """;
        
        analizar(entrada); 
        System.out.println(codigo.Parser.resultado);

        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<!DOCTYPE html>\n");
        htmlTable.append("<html>\n");
        htmlTable.append("<head>\n");
        htmlTable.append("<title>Tokens</title>\n");
        htmlTable.append("<style>\n");
        htmlTable.append("table {\n");
        htmlTable.append("  border-collapse: collapse;\n");
        htmlTable.append("  width: 100%;\n");
        htmlTable.append("}\n");
        htmlTable.append("th, td {\n");
        htmlTable.append("  border: 1px solid black;\n");
        htmlTable.append("  padding: 8px;\n");
        htmlTable.append("  text-align: left;\n");
        htmlTable.append("}\n");
        htmlTable.append("th {\n");
        htmlTable.append("  background-color: #f2f2f2;\n");
        htmlTable.append("}\n");
        htmlTable.append("</style>\n");
        htmlTable.append("</head>\n");
        htmlTable.append("<body>\n");
        htmlTable.append("<h1>Tabla de Tokens</h1>\n");
        htmlTable.append("<table>\n");
        htmlTable.append("<tr><th>#</th><th>Token</th><th>Linea</th><th>Columna</th><th>Tipo</th></tr>\n");
        
        int tokenCount = 1; // Inicializamos el contador de tokens
        
        for (codigo.Token token : codigo.Lexer.tokens) {
            htmlTable.append("<tr><td>");
            htmlTable.append(tokenCount); // Agregamos el número de token
            htmlTable.append("</td><td>");
            htmlTable.append(token.type);
            htmlTable.append("</td><td>");
            htmlTable.append(token.line);
            htmlTable.append("</td><td>");
            htmlTable.append(token.column);
            htmlTable.append("</td><td>");
            htmlTable.append(token.name);
            htmlTable.append("</td></tr>\n");
            tokenCount++; // Incrementamos el contador de tokens
        }
        htmlTable.append("</table>\n");
        htmlTable.append("</body>\n");
        htmlTable.append("</html>\n");

        String filename = "tokens.html";
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(htmlTable.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        URI fileURI = new File(filename).toURI();

        try {
            Desktop.getDesktop().browse(fileURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Errores
        StringBuilder htmlErrorTable = new StringBuilder();
        htmlErrorTable.append("<!DOCTYPE html>\n");
        htmlErrorTable.append("<html>\n");
        htmlErrorTable.append("<head>\n");
        htmlErrorTable.append("<title>Errores</title>\n");
        htmlErrorTable.append("<style>\n");
        htmlErrorTable.append("table {\n");
        htmlErrorTable.append("  border-collapse: collapse;\n");
        htmlErrorTable.append("  width: 100%;\n");
        htmlErrorTable.append("}\n");
        htmlErrorTable.append("th, td {\n");
        htmlErrorTable.append("  border: 1px solid black;\n");
        htmlErrorTable.append("  padding: 8px;\n");
        htmlErrorTable.append("  text-align: left;\n");
        htmlErrorTable.append("}\n");
        htmlErrorTable.append("th {\n");
        htmlErrorTable.append("  background-color: #f2f2f2;\n");
        htmlErrorTable.append("}\n");
        htmlErrorTable.append("</style>\n");
        htmlErrorTable.append("</head>\n");
        htmlErrorTable.append("<body>\n");
        htmlErrorTable.append("<h1>Errores</h1>\n");
        htmlErrorTable.append("<table>\n");
        htmlErrorTable.append("<tr><th>#</th><th>Error</th><th>Línea</th><th>Columna</th></tr>\n");

        int errorCount = 1; // Inicializamos el contador de errores

        for (codigo.Errores error : codigo.Lexer.errores) {
            htmlErrorTable.append("<tr><td>");
            htmlErrorTable.append(errorCount); // Agregamos el número de error
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getErrorMessage());
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getLine());
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getColumn());
            htmlErrorTable.append("</td></tr>\n");
            errorCount++; // Incrementamos el contador de errores
        }
        for (codigo.Errores error : codigo.Parser.listaDeErrores) {
            htmlErrorTable.append("<tr><td>");
            htmlErrorTable.append(errorCount); // Agregamos el número de error
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getErrorMessage());
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getLine());
            htmlErrorTable.append("</td><td>");
            htmlErrorTable.append(error.getColumn());
            htmlErrorTable.append("</td></tr>\n");
            errorCount++; // Incrementamos el contador de errores
        }

        htmlErrorTable.append("</table>\n");
        htmlErrorTable.append("</body>\n");
        htmlErrorTable.append("</html>\n");

        String errorFilename = "errores_lexicos.html";
        try (PrintWriter out = new PrintWriter(errorFilename)) {
            out.println(htmlErrorTable.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        URI errorFileURI = new File(errorFilename).toURI();

        try {
            Desktop.getDesktop().browse(errorFileURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Simbolos
        StringBuilder htmlSymbolTable = new StringBuilder();
        htmlSymbolTable.append("<!DOCTYPE html>\n");
        htmlSymbolTable.append("<html>\n");
        htmlSymbolTable.append("<head>\n");
        htmlSymbolTable.append("<title>Tabla de Símbolos</title>\n");
        htmlSymbolTable.append("<style>\n");
        htmlSymbolTable.append("table {\n");
        htmlSymbolTable.append("  border-collapse: collapse;\n");
        htmlSymbolTable.append("  width: 100%;\n");
        htmlSymbolTable.append("}\n");
        htmlSymbolTable.append("th, td {\n");
        htmlSymbolTable.append("  border: 1px solid black;\n");
        htmlSymbolTable.append("  padding: 8px;\n");
        htmlSymbolTable.append("  text-align: left;\n");
        htmlSymbolTable.append("}\n");
        htmlSymbolTable.append("th {\n");
        htmlSymbolTable.append("  background-color: #f2f2f2;\n");
        htmlSymbolTable.append("}\n");
        htmlSymbolTable.append("</style>\n");
        htmlSymbolTable.append("</head>\n");
        htmlSymbolTable.append("<body>\n");
        htmlSymbolTable.append("<h1>Tabla de Simbolos</h1>\n");
        htmlSymbolTable.append("<table>\n");
        htmlSymbolTable.append("<tr><th>#</th><th>Nombre</th><th>Tipo</th><th>Valor</th><th>Linea</th><th>Columna</th></tr>\n");
        
        int symbolCount = 1; // Inicializamos el contador de símbolos
        
        for (codigo.Simbolos symbol : codigo.Parser.simbolos) {
            htmlSymbolTable.append("<tr><td>");
            htmlSymbolTable.append(symbolCount); // Agregamos el número de símbolo
            htmlSymbolTable.append("</td><td>");
            htmlSymbolTable.append(symbol.getName());
            htmlSymbolTable.append("</td><td>");
            htmlSymbolTable.append(symbol.getType());
            htmlSymbolTable.append("</td><td>");
            htmlSymbolTable.append(symbol.getValue());
            htmlSymbolTable.append("</td><td>");
            htmlSymbolTable.append(symbol.getLine());
            htmlSymbolTable.append("</td><td>");
            htmlSymbolTable.append(symbol.getColumn());
            htmlSymbolTable.append("</td></tr>\n");
            symbolCount++; // Incrementamos el contador de símbolos
        }
        
        htmlSymbolTable.append("</table>\n");
        htmlSymbolTable.append("</body>\n");
        htmlSymbolTable.append("</html>\n");

        String symbolFilename = "tabla_simbolos.html";
        try (PrintWriter out = new PrintWriter(symbolFilename)) {
            out.println(htmlSymbolTable.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        URI symbolFileURI = new File(symbolFilename).toURI();

        try {
            Desktop.getDesktop().browse(symbolFileURI);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
    public static void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            JFlex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
    
    // Realizar Analisis
    public static void analizar (String entrada){
        try {
            codigo.Lexer lexer = new codigo.Lexer(new StringReader(entrada)); 
            codigo.Parser parser = new codigo.Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        } 
    } 
}
