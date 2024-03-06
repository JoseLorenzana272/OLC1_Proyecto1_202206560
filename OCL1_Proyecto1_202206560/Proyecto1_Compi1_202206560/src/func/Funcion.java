package func;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Funcion {
    private static Map<String, Object> variables = new HashMap<>();

    public static String mostrar(String expresion){
        return String.valueOf(expresion) + "\n";
    }

    public static String declararDouble(String nombreVariable, String valor) {
        double numero = Double.parseDouble(valor);
        /*String[] partes = valor.substring(1, valor.length() - 1).split(",(?![^()]*\\))");
        double[] arreglo = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].trim();
            if (parte.startsWith("SUM") || parte.startsWith("RES") || parte.startsWith("MUL") || parte.startsWith("DIV") || parte.startsWith("MOD")) {
                
                arreglo[i] = evaluarOperacion(parte);
            } else if (variables.containsKey(parte)) {
                arreglo[i] = (Double) variables.get(parte);
            } else {
                arreglo[i] = Double.parseDouble(parte);
            }
        }*/
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
        String[] partes = valores.substring(1, valores.length() - 1).split(",(?![^()]*\\))");
        double[] arreglo = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].trim();
            if (parte.startsWith("SUM") || parte.startsWith("RES") || parte.startsWith("MUL") || parte.startsWith("DIV") || parte.startsWith("MOD")) {
                
                arreglo[i] = evaluarOperacion(parte);
            } else if (variables.containsKey(parte)) {
                arreglo[i] = (Double) variables.get(parte);
            } else {
                arreglo[i] = Double.parseDouble(parte);
            }
        }
        for (double k:arreglo){
            System.out.println("Melvin: "+k);
        }
        variables.put(nombreArreglo, arreglo);
        
        return "Arreglo " + nombreArreglo + " de tipo double declarado con valores: " + valores + "\n";
    }

    private static double evaluarOperacion(String operacion) {
        if (operacion.startsWith("SUM")) {
            String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
            return Double.parseDouble(sumar(numeros[0].trim(), numeros[1].trim()));
        } else if (operacion.startsWith("RES")) {
            String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
            return Double.parseDouble(restar(numeros[0].trim(), numeros[1].trim()));
        } else if (operacion.startsWith("MUL")) {
            String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
            return Double.parseDouble(multiplicar(numeros[0].trim(), numeros[1].trim()));
        } else if (operacion.startsWith("DIV")) {
            String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
            return Double.parseDouble(dividir(numeros[0].trim(), numeros[1].trim()));
        } else if (operacion.startsWith("MOD")) {
            String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
            return Double.parseDouble(modular(numeros[0].trim(), numeros[1].trim()));
        } else {
            return Double.parseDouble(operacion);
        }
    }

    private static double evaluarEstadistica(String opEstadistica){
        if (opEstadistica.startsWith("Media")) {
            String[] numeros = opEstadistica.substring(4, opEstadistica.length() - 1).split(",");
            return Double.parseDouble(media(numeros[0]));
        } else if (opEstadistica.startsWith("Mediana")) {
            String[] numeros = opEstadistica.substring(4, opEstadistica.length() - 1).split(",");
            return Double.parseDouble(restar(numeros[0].trim(), numeros[1].trim()));
        } else if (opEstadistica.startsWith("Moda")) {
            String[] numeros = opEstadistica.substring(4, opEstadistica.length() - 1).split(",");
            return Double.parseDouble(multiplicar(numeros[0].trim(), numeros[1].trim()));
        } else if (opEstadistica.startsWith("Varianza")) {
            String[] numeros = opEstadistica.substring(4, opEstadistica.length() - 1).split(",");
            return Double.parseDouble(dividir(numeros[0].trim(), numeros[1].trim()));
        } else if (opEstadistica.startsWith("Max")) {
            String[] numeros = opEstadistica.substring(4, opEstadistica.length() - 1).split(",");
            return Double.parseDouble(modular(numeros[0].trim(), numeros[1].trim()));
        } else {
            return Double.parseDouble(opEstadistica);
        }
    }



    public static String declararArregloChar(String nombreArreglo, String valores) {
        String[] arreglo = parseStringArray(valores);
        
        variables.put(nombreArreglo, arreglo);
        return "Arreglo " + nombreArreglo + " de tipo char[] declarado con valores: " + valores + "\n";
    }

    private static double[] parseDoubleArray(String valores) {
        String[] partes = valores.substring(1, valores.length() - 1).split(",(?![^()]*\\))");
        double[] arreglo = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            String valor = partes[i].trim();
            if (valor.startsWith("SUM")) {
                String parametros = valor.substring(4, valor.length() - 1);
                String[] numeros = parametros.split(",");
                String valorA = numeros[0].trim();
                String valorB = numeros[1].trim();
                arreglo[i] = Double.parseDouble(sumar(valorA, valorB));
            } else if (valor.startsWith("RES")) {
                String parametros = valor.substring(4, valor.length() - 1);
                String[] numeros = parametros.split(",");
                String valorA = numeros[0].trim();
                String valorB = numeros[1].trim();
                arreglo[i] = Double.parseDouble(restar(valorA, valorB));
            } else if (valor.startsWith("MUL")) {
                String parametros = valor.substring(4, valor.length() - 1);
                String[] numeros = parametros.split(",");
                String valorA = numeros[0].trim();
                String valorB = numeros[1].trim();
                arreglo[i] = Double.parseDouble(multiplicar(valorA, valorB));
            } else if (valor.startsWith("DIV")) {
                String parametros = valor.substring(4, valor.length() - 1);
                String[] numeros = parametros.split(",");
                String valorA = numeros[0].trim();
                String valorB = numeros[1].trim();
                arreglo[i] = Double.parseDouble(dividir(valorA, valorB));
            }else if (valor.startsWith("MOD")) {
                String parametros = valor.substring(4, valor.length() - 1);
                String[] numeros = parametros.split(",");
                String valorA = numeros[0].trim();
                String valorB = numeros[1].trim();
                arreglo[i] = Double.parseDouble(modular(valorA, valorB));
            }else if (valor.matches("[a-zA-Z]+")) {
                // Si el valor es un identificador de variable (nombre variable)
                Object valorVariable = obtenerValor(valor);
                if (valorVariable != null) {
                    arreglo[i] = Double.parseDouble(valorVariable.toString());
                } else {
                    throw new IllegalArgumentException("Variable " + valor + " no definida.");
                }
            }
            else {
                arreglo[i] = Double.parseDouble(valor);
            }
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
        System.out.println("MAÑANA QUEEEEEEE: "+ resultado);

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
    
    public static String media(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // Si los valores comienzan con '@', es un identificador de arreglo (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {

                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        double suma = 0;
        for (double valor : arreglo) {
            suma += valor;
        }
        double media = suma / arreglo.length;
        return String.valueOf(media);
    }


    public static String mediana(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {
                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        Arrays.sort(arreglo);
        double mediana;
        if (arreglo.length % 2 == 0) {
            mediana = (arreglo[arreglo.length / 2 - 1] + arreglo[arreglo.length / 2]) / 2;
        } else {
            mediana = arreglo[arreglo.length / 2];
        }
        return String.valueOf(mediana);
    }


    public static String moda(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {
                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double valor : arreglo) {
            frecuencias.put(valor, frecuencias.getOrDefault(valor, 0) + 1);
        }
        double moda = Double.MIN_VALUE;
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }
        return String.valueOf(moda);
    }


    public static String varianza(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {
                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        double media = Double.parseDouble(media(valores));
        double sumaCuadradosDiferencias = 0;
        for (double valor : arreglo) {
            sumaCuadradosDiferencias += Math.pow(valor - media, 2);
        }
        double varianza = sumaCuadradosDiferencias / arreglo.length;
        return String.valueOf(varianza);
    }


    public static String maximo(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {
                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        double max = Double.MIN_VALUE;
        for (double valor : arreglo) {
            max = Math.max(max, valor);
        }
        return String.valueOf(max);
    }

    public static String minimo(String valores) {
        double[] arreglo;
        if (valores.startsWith("@")) {
            // (es un nombre de arreglo) :D
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor != null) {
                arreglo = (double[]) valor;
            } else {
                throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
            }
        } else {
            // Arreglo normal
            arreglo = parseDoubleArray(valores);
        }
        double min = Double.MAX_VALUE;
        for (double valor : arreglo) {
            min = Math.min(min, valor);
        }
        return String.valueOf(min);
    }



}
