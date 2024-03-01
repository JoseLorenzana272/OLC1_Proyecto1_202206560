/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.io.StringReader;

/**
 *
 * @author PERSONAL
 */
public class Main {
    public static void main(String[] args) {
        analizadores("src/codigo/", "Lexer.jflex", "Parser.cup");
        
        String entrada = """
                         PROGRAM
                         MOSTRAR ( 2*7 + 3);
                         var:   double::numero <- 2.5 end;
                         var:char[]::cadena <- "cadena" end;
                         arr:double::@darray <- [1, 2, 3, 4, 5] end;
                         MOStrAR(452+ 3);
                         arr:char[]::@carray <- ["cadena1", "cadena2", "cadena3"] end;
                         var:double::hola <- SUM(5, 2) end;
                         var:double::resta <- REs(8, 3) end;
                         arr:double::@prueba <- [1, 5, 45, numero] end;
                         arr:char[]::@carajo <- ["hola", "adios", "mañana"] end;
                         var:double::multi <- MUL(5, 15) end;
                         var:double::divi <- DIV(85,4) end;
                         var:double::divi <- SUM(MUL(5,2),DIV(50,5)) end;
                         END PROGRAM
                         """;
        //arr:double::@queso <- [SUM(5, 2), 5, REs(8, 3), numero] end;
        analizar(entrada); System.out.println(codigo.Parser.resultado);
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
