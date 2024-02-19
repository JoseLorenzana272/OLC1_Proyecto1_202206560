package func;

import java.util.HashMap;
import java.util.Map;

public class Funcion {
    private static Map<String, Object> variables = new HashMap<>();

    public static String mostrar(String expresion){
        return String.valueOf(expresion) + "\n";
    }

    public static String declararDouble(String valor) {
        double numero = Double.parseDouble(valor);
        // Aquí deberías agregar el código para almacenar 'numero' en tu tabla de símbolos o estructura de datos similar
        variables.put("numero", numero);
        return "Variable 'numero' de tipo double declarada con valor: " + numero + "\n";
    }

    public static String declararCadena(String valor) {
        // Aquí deberías agregar el código para almacenar 'valor' en tu tabla de símbolos o estructura de datos similar
        variables.put("cadena", valor);
        return "Variable 'cadena' de tipo char[] declarada con valor: " + valor + "\n";
    }

    public static String asignarValor(String nombreVariable, String valor) {
        // Aquí deberías agregar el código para actualizar el valor de 'nombreVariable' en tu tabla de símbolos o estructura de datos similar
        variables.put(nombreVariable, valor);
        return "Variable '" + nombreVariable + "' actualizada con valor: " + valor + "\n";
    }

    public static Object obtenerValor(String nombreVariable) {
        // Aquí deberías agregar el código para obtener el valor de 'nombreVariable' de tu tabla de símbolos o estructura de datos similar
        return variables.get(nombreVariable);
    }
    
    public static String declararArregloDouble(String valores) {
        double[] arreglo = parseDoubleArray(valores);
        // Aquí deberías agregar el código para almacenar 'arreglo' en tu tabla de símbolos o estructura de datos similar
        variables.put("darray", arreglo);
        return "Arreglo 'darray' de tipo double declarado con valores: " + valores + "\n";
    }

    public static String declararArregloChar(String valores) {
        String[] arreglo = parseStringArray(valores);
        // Aquí deberías agregar el código para almacenar 'arreglo' en tu tabla de símbolos o estructura de datos similar
        variables.put("carray", arreglo);
        return "Arreglo 'carray' de tipo char[] declarado con valores: " + valores + "\n";
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
        // Aquí deberías agregar el código para convertir la cadena 'valores' en un arreglo de cadenas
        String[] partes = valores.substring(1, valores.length() - 1).split(",");
        String[] arreglo = new String[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arreglo[i] = partes[i].trim().substring(1, partes[i].length() - 1);
        }
        return arreglo;
    }
}
