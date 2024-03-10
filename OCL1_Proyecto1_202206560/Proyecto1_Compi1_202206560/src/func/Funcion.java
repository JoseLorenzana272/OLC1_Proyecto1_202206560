package func;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

public class Funcion {
    private static Map<String, Object> variables = new HashMap<>();

    public static String mostrar(String expresion){
        return String.valueOf(expresion) + "\n";
    }
    
    public static String imprimir(String expresion){
        return String.valueOf(expresion) + "\n";
    }
    
    public static String imprimirColumna(String titulo, String valores) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------------\n");

        // Verificar si el título es un identificador de variable
        if (titulo.startsWith("@")) {
            titulo = titulo.substring(1);
            Object valorTitulo = obtenerValor(titulo);
            if (valorTitulo != null) {
                sb.append(valorTitulo.toString());
            } else {
                throw new IllegalArgumentException("No se encontró un valor para el identificador '" + titulo + "'.");
            }
        } else {
            sb.append(titulo);
        }

        sb.append("\n--------------\n");

        // Verificar si los valores son un arreglo o una variable de arreglo
        if (valores.startsWith("@")) {
            // Si los valores comienzan con '@', es un identificador de arreglo
            String nombreArreglo = valores.substring(1);
            Object valor = obtenerValor(nombreArreglo);
            if (valor instanceof double[]) {
                double[] arregloDouble = (double[]) valor;
                for (double valorDouble : arregloDouble) {
                    sb.append(valorDouble).append("\n");
                }
            } else if (valor instanceof String[]) {
                String[] arregloChar = (String[]) valor;
                for (String valorChar : arregloChar) {
                    sb.append(valorChar).append("\n");
                }
            } else {
                throw new IllegalArgumentException("El valor de la variable '" + nombreArreglo + "' no es un arreglo.");
            }
        } else {
            // Arreglo normal

            String[] partes = valores.substring(1, valores.length() - 1).split(",(?![^()]*\\))");
            double[] arreglo = new double[partes.length];
            for (int i = 0; i < partes.length; i++) {
                String parte = partes[i].trim();
                if (parte.startsWith("SUM") || parte.startsWith("RES") || parte.startsWith("MUL") || parte.startsWith("DIV") || parte.startsWith("MOD")) {
                    arreglo[i] = evaluarOperacion(parte);
                } else if (parte.matches("[a-zA-Z]+")) {
                    arreglo[i] = obtenerValor(parte) != null ? Double.parseDouble(obtenerValor(parte).toString()) : 0;
                } else {
                    arreglo[i] = Double.parseDouble(parte);
                }
            }
            for (double valor : arreglo) {
                sb.append(valor).append("\n"); // Añade el valor al StringBuilder seguido de un salto de línea
            }
        }
        
        return sb.toString();
    }


    
    public static String declararDouble(String nombreVariable, String valor) {
        double numero = Double.parseDouble(valor);
        
        variables.put(nombreVariable, numero);
        
        return "";
    }

    public static String declararCadena(String nombreVariable, String valor) {

        variables.put(nombreVariable, valor);
        return "";
    }

    public static String asignarValor(String nombreVariable, String valor) {
        
        variables.put(nombreVariable, valor);
        return "";
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
        } else if (parte.matches("[a-zA-Z]+")) {
            arreglo[i] = obtenerValor(parte) != null ? Double.parseDouble(obtenerValor(parte).toString()) : 0;
        } else {
            arreglo[i] = Double.parseDouble(parte);
        }
    }
    variables.put(nombreArreglo, arreglo);
    return "";
}

private static double evaluarOperacion(String operacion) {
    if (operacion.startsWith("SUM")) {
        String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
        /*if (numeros[0].startsWith("SUM") || numeros[0].startsWith("RES") || numeros[0].startsWith("MUL")|| numeros[0].startsWith("DIV")|| numeros[0].startsWith("MOD")){
            String[] numeros2 = operacion.substring(4, operacion.length() - 1).split(",");
            double resultado = evaluarOperacion(numeros2[0].trim()) + evaluarOperacion(numeros2[1].trim());
            numeros[0] = String.valueOf(resultado);
        }*/
        return evaluarOperacion(numeros[0].trim()) + evaluarOperacion(numeros[1].trim());
    } else if (operacion.startsWith("RES")) {
        String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
        return evaluarOperacion(numeros[0].trim()) - evaluarOperacion(numeros[1].trim());
    } else if (operacion.startsWith("MUL")) {
        String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
        return evaluarOperacion(numeros[0].trim()) * evaluarOperacion(numeros[1].trim());
    } else if (operacion.startsWith("DIV")) {
        String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
        return evaluarOperacion(numeros[0].trim()) / evaluarOperacion(numeros[1].trim());
    } else if (operacion.startsWith("MOD")) {
        String[] numeros = operacion.substring(4, operacion.length() - 1).split(",");
        return evaluarOperacion(numeros[0].trim()) % evaluarOperacion(numeros[1].trim());
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
        for (String val: arreglo){
            System.out.println("Pato: "+val);
        }
        return "";
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
        
        String[] partes = valores.substring(0, valores.length()-1).split(",");
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
    
    
    public static String graficarBarra(String titulo, String valoresX, String valoresY, String tituloEjeX, String tituloEjeY) {
        // Eliminar los corchetes de los valores de X y Y
        valoresX = valoresX.replace("[", "").replace("]", "");
        
        String[] partes = valoresY.substring(1, valoresY.length() - 1).split(",(?![^()]*\\))");
            double[] arreglo = new double[partes.length];
            for (int i = 0; i < partes.length; i++) {
                String parte = partes[i].trim();
                if (parte.startsWith("SUM") || parte.startsWith("RES") || parte.startsWith("MUL") || parte.startsWith("DIV") || parte.startsWith("MOD")) {
                    arreglo[i] = evaluarOperacion(parte);
                } else if (parte.matches("[a-zA-Z]+")) {
                    arreglo[i] = obtenerValor(parte) != null ? Double.parseDouble(obtenerValor(parte).toString()) : 0;
                } else {
                    arreglo[i] = Double.parseDouble(parte);
                }
            }
            

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Dividir los valores de X y Y por comas
        String[] partesX = valoresX.split(",");

        // Agregar los valores al conjunto de datos
        for (int i = 0; i < partesX.length; i++) {
            dataset.addValue(arreglo[i], tituloEjeY, partesX[i]);
        }

        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                titulo,        // Título del gráfico
                tituloEjeX,    // Etiqueta del eje X
                tituloEjeY,    // Etiqueta del eje Y
                dataset        // Conjunto de datos
        );

        // Crear un panel de gráfico y agregar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);

        // Crear un marco para la ventana y agregar el panel del gráfico
        JFrame frame = new JFrame("Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Devolver un mensaje indicando que la gráfica se ha generado exitosamente
        return "Gráfico de barras generado con éxito.";
    }

    public static String graficarPie(String titulo, String etiquetas, String valores) {
        // Eliminar los corchetes de las etiquetas y los valores
        etiquetas = etiquetas.replace("[", "").replace("]", "");
        valores = valores.replace("[", "").replace("]", "");

        // Dividir las etiquetas y los valores por comas
        String[] partesEtiquetas = etiquetas.split(",");
        String[] partesValores = valores.split(",");

        // Evaluar las operaciones y asignar los valores al arreglo
        double[] arreglo = new double[partesValores.length];
        for (int i = 0; i < partesValores.length; i++) {
            String parteValor = partesValores[i].trim();
            if (parteValor.startsWith("SUM") || parteValor.startsWith("RES") || parteValor.startsWith("MUL") || parteValor.startsWith("DIV") || parteValor.startsWith("MOD")) {
                arreglo[i] = evaluarOperacion(parteValor);
            } else if (parteValor.matches("[a-zA-Z]+")) {
                Object valorVariable = obtenerValor(parteValor);
                arreglo[i] = valorVariable != null ? Double.parseDouble(valorVariable.toString()) : 0;
            } else {
                arreglo[i] = Double.parseDouble(parteValor);
            }
        }

        // Crear un conjunto de datos para el gráfico de pie
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Agregar las etiquetas y los valores al conjunto de datos
        for (int i = 0; i < partesEtiquetas.length; i++) {
            dataset.setValue(partesEtiquetas[i].trim(), arreglo[i]);
        }

        // Crear el gráfico de pie
        JFreeChart chart = ChartFactory.createPieChart(
                titulo,    // Título del gráfico
                dataset,   // Conjunto de datos
                true,      // Mostrar leyenda
                true,      // Mostrar tooltips
                false      // No mostrar URLs
        );

        // Crear un panel de gráfico y agregar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);

        // Crear un marco para la ventana y agregar el panel del gráfico
        JFrame frame = new JFrame("Gráfico de Pie");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Devolver un mensaje indicando que el gráfico se ha generado exitosamente
        return "Gráfico de pie generado con éxito.";
    }

    public static String graficarLinea(String titulo, String valoresX, String valoresY, String tituloEjeX, String tituloEjeY) {
    // Eliminar los corchetes de los valores de X y Y
    valoresX = valoresX.replace("[", "").replace("]", "");
    
    double[] arregloY;
    if (valoresY.startsWith("@")) {
        // Es un nombre de arreglo
        String nombreArreglo = valoresY.substring(1);
        Object valor = obtenerValor(nombreArreglo);
        if (valor != null) {
            arregloY = (double[]) valor;
        } else {
            throw new IllegalArgumentException("Arreglo " + nombreArreglo + " no definido.");
        }
    } else {
        // Arreglo normal
        String[] partes = valoresY.substring(1, valoresY.length() - 1).split(",(?![^()]*\\))");
        arregloY = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].trim();
            if (parte.startsWith("SUM") || parte.startsWith("RES") || parte.startsWith("MUL") || parte.startsWith("DIV") || parte.startsWith("MOD")) {
                arregloY[i] = evaluarOperacion(parte);
            } else if (parte.matches("[a-zA-Z]+")) {
                Object valorVariable = obtenerValor(parte);
                arregloY[i] = valorVariable != null ? Double.parseDouble(valorVariable.toString()) : 0;
            } else {
                arregloY[i] = Double.parseDouble(parte);
            }
        }
    }

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Dividir los valores de X por comas
    String[] partesX = valoresX.split(",");

    // Agregar los valores al conjunto de datos
    for (int i = 0; i < partesX.length; i++) {
        dataset.addValue(arregloY[i], tituloEjeY, partesX[i]);
    }

    // Crear el gráfico de líneas
    JFreeChart chart = ChartFactory.createLineChart(
            titulo,        // Título del gráfico
            tituloEjeX,    // Etiqueta del eje X
            tituloEjeY,    // Etiqueta del eje Y
            dataset        // Conjunto de datos
    );

    // Crear un panel de gráfico y agregar el gráfico
    ChartPanel chartPanel = new ChartPanel(chart);

    // Crear un marco para la ventana y agregar el panel del gráfico
    JFrame frame = new JFrame("Gráfico de Línea");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(chartPanel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);

    // Devolver un mensaje indicando que la gráfica se ha generado exitosamente
    return "Gráfico de línea generado con éxito.";
}



public static String graficarhistograma(String titulo, String valores) {
        // Eliminar los corchetes de los valores
        valores = valores.replace("[", "").replace("]", "");

        // Dividir los valores por comas y convertirlos a un arreglo de doubles
        String[] partes = valores.split(",");
        double[] arreglo = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            arreglo[i] = Double.parseDouble(partes[i].trim());
        }

        // Crear un mapa para almacenar la frecuencia de cada valor único
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double valor : arreglo) {
            frecuencia.put(valor, frecuencia.getOrDefault(valor, 0) + 1);
        }

        // Crear un conjunto para almacenar los valores únicos
        // Esto garantiza que solo tengamos un valor único una vez
        Double[] valoresUnicos = frecuencia.keySet().toArray(new Double[0]);
        Arrays.sort(valoresUnicos);

        // Calcular la frecuencia acumulada y la frecuencia relativa
        int fa = 0;
        StringBuilder analysis = new StringBuilder();
        analysis.append("Analisis de Arreglo\n");
        analysis.append("----------------------------------\n");
        analysis.append(String.format("%-10s %-15s %-15s %-10s\n", "Valor", "Fb", "Fa", "Fr"));
        analysis.append("----------------------------------\n");
        for (double valor : valoresUnicos) {
            int fb = frecuencia.get(valor);
            fa += fb;
            double fr = (fa * 100.0) / arreglo.length;
            analysis.append(String.format("%-10.2f %-15d %-15d %-10.2f%%\n", valor, fb, fa, fr));
        }
        analysis.append("----------------------------------\n");
        analysis.append(String.format("%-10s %-15d %-15d %-10d%%\n", "Totales:", arreglo.length, arreglo.length, 100));
        analysis.append("\n");

        // Imprimir el análisis en consola
        System.out.println(analysis.toString());

        // Crear el conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Histograma", arreglo, 10); // 10 es el número de barras

        // Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createXYBarChart(
        titulo,            // Título del gráfico
        "Valor",           // Etiqueta del eje X
        false,             // Invertir eje X
        "Frecuencia",      // Etiqueta del eje Y
        dataset,           // Conjunto de datos
        PlotOrientation.VERTICAL,  // Orientación del gráfico
        true,              // Mostrar leyenda
        true,              // Mostrar tooltips
        false              // No mostrar URLs
);

        // Crear un panel de gráfico y agregar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);

        // Crear un marco para la ventana y agregar el panel del gráfico
        JFrame frame = new JFrame("Histograma");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Devolver un mensaje indicando que el histograma se ha generado exitosamente
        return "Histograma generado con éxito.";
    }

}
