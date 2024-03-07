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
                         MOSTRAR ( 2*7 + 3);
                         var:   double::numero <- 2.5 end;
                         var:   double::Sazo <- 123.85 end;
                         var:char[]::cadena <- "cadena" end;
                         arr:double::@darray <- [1, 2, 3, 4, 5] end;
                         MOStrAR(452+ 3);
                         arr:char[]::@carray <- ["cadena1", "cadena2", "cadena3"] end;
                         var:double::hola <- SUM(5, 2) end;
                         var:double::resta <- REs(8, 3) end;
                         arr:double::@prueba <- [1, 5, 45, numero, MUL(5, 7)] end;
                         arr:char[]::@carajo <- ["hola", "adios", "mañana"] end;
                         var:double::multi <- MUL(5, 15) end;
                         var:double::divi <- DIV(85,4) end;
                         arr:double::@queso <- [SUM(5, 2), 5, RES(8, 3), Sazo, MOD(85,2)] end;
                         var:double::divi <- SUM(MUL(5,2),DIV(50,5)) end;
                         var:double:: med1 <- Media([1, 2, 45, 4, 8]) end;
                         var:double:: MARIO <- Media([RES(6,1), SUM(4,2), 4]) end;
                         var:double:: med2 <- Media(@darray) end;
                         var:double:: med3 <- Media([1, 2, SUM(4,2), 4]) end;
                         var:double:: medianaaaa <- Mediana([2, 8, 4]) end;
                         var:double:: medianaaaa2 <- Mediana([2, 8, 5, DIV(15,3)]) end;
                         var:double:: modaaa <- Moda([2, 4, 2, 5, 6, 2]) end;
                         var:double:: modaaa2 <- Moda([2, 4, 5, 6, 4, RES(8,4)]) end;
                         var:double:: vari1 <- Varianza([2, numero, 8, 7, MOD(4,5)]) end;
                         var:double:: maxi1 <- MAX([2, numero, 8, 7, MOD(4,5)]) end;
                         var:double:: mitad <- DIV( SUM(Max(@darray), Min(@darray) ), 2) end;
                         console::print = "holsdsda", 5, numero, SUM(2,1) end;
                         console::print = 1, 2, SUM(3,5), Media(@queso) end;
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
