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
}
