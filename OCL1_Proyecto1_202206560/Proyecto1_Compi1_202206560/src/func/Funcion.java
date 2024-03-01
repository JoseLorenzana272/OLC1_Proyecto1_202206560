package func;

import java.util.HashMap;
import java.util.Map;

public class Funcion {
    private static Map<String, Object> variables = new HashMap<>();

    public static String mostrar(String expresion){
        return String.valueOf(expresion) + "\n";
    }

    public static String declararDouble(String nombreVariable, String valor) {
        double numero = Double.parseDouble(valor);

        variables.put(nombreVariable, numero);
        return "Variable '" + nombreVariable + "' de tipo double declarada con valor: " + numero + "\n";
    }

    public static String declararCadena(String nombreVariable, String valor) {

        variables.put(nombreVariable, valor);
        return "Variable '" + nombreVariable + "' de tipo char[] declarada con valor: " + valor + "\n";
    }

    public static String asignarValor(String nombreVariable, String valor) {
        
        variables.put(nombreVariable, valor);
        return "Variable '" + nombreVariable + "' actualizada con valor: " + valor + "\n";
    }

    public static Object obtenerValor(String nombreVariable) {
        
        return variables.get(nombreVariable);
    }
    
    public static String declararArregloDouble(String nombreArreglo, String valores) {
    String[] partes = valores.substring(1, valores.length() - 1).split(",");
    double[] arreglo = new double[partes.length];
    for (int i = 0; i < partes.length; i++) {
        String parte = partes[i].trim();
        if (variables.containsKey(parte)) {
            arreglo[i] = (Double) variables.get(parte);
        } else {
            arreglo[i] = Double.parseDouble(parte);
        }
    }
    variables.put(nombreArreglo, arreglo);
    return "Arreglo " + nombreArreglo + " de tipo double declarado con valores: " + valores + "\n";
}



    public static String declararArregloChar(String nombreArreglo, String valores) {
        String[] arreglo = parseStringArray(valores);
        
        variables.put(nombreArreglo, arreglo);
        return "Arreglo " + nombreArreglo + " de tipo char[] declarado con valores: " + valores + "\n";
    }

    private static double[] parseDoubleArray(String valores) {
        // Aquí deberías agregar el código para convertir la cadena 'valores' en un arreglo de double
        String[] partes = valores.substring(1, valores.length() - 1).split(",");
        double[] arreglo = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arreglo[i] = Double.parseDouble(partes[i].trim());
        }
        return arreglo;
    }

    private static String[] parseStringArray(String valores) {
        
        String[] partes = valores.substring(1, valores.length() - 1).split(",");
        String[] arreglo = new String[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arreglo[i] = partes[i].trim().substring(1, partes[i].length() - 1);
        }
        return arreglo;
    }
    
    public static String sumar(String valorA, String valorB) {
        double numeroA = Double.parseDouble(valorA);
        double numeroB = Double.parseDouble(valorB);
        double resultado = numeroA + numeroB;

        return String.valueOf(resultado);
    }
    
    public static String restar(String valorA, String valorB) {
        double numeroA = Double.parseDouble(valorA);
        double numeroB = Double.parseDouble(valorB);
        double resultado = numeroA - numeroB;

        return String.valueOf(resultado);
    }
    
    public static String multiplicar(String valorA, String valorB) {
        double numeroA = Double.parseDouble(valorA);
        double numeroB = Double.parseDouble(valorB);
        double resultado = numeroA * numeroB;

        return String.valueOf(resultado);
    }
    
    public static String dividir(String valorA, String valorB) {
        double numeroA = Double.parseDouble(valorA);
        double numeroB = Double.parseDouble(valorB);
        double resultado = numeroA / numeroB;

        return String.valueOf(resultado);
    }
    
    public static String modular(String valorA, String valorB) {
        double numeroA = Double.parseDouble(valorA);
        double numeroB = Double.parseDouble(valorB);
        double resultado = numeroA % numeroB;

        return String.valueOf(resultado);
    }

}
