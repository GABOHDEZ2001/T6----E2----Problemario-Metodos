package Problemario;

public class MetodoDeUnPaso5 {

    // Definimos la función f(x, y) que describe la EDO. En este caso, usamos f(x, y) = x * y^2.
    public static double f(double x, double y) {
        return x * y * y;
    }

    // Implementamos el Método de Un Paso (Euler) para resolver la EDO
    public static void euler(double x0, double y0, double xEnd, double step) {
        double x = x0;
        double y = y0;

        // Imprimir el punto inicial
        System.out.printf("x = %.4f, y = %.4f%n", x, y);

        // Iterar mientras x no haya alcanzado el valor final xEnd
        while (x < xEnd) {
            y = y + step * f(x, y); // Aplicar el método de Euler para actualizar y
            x = x + step; // Incrementar x por el tamaño del paso

            // Imprimir el nuevo punto (x, y)
            System.out.printf("x = %.4f, y = %.4f%n", x, y);
        }
    }

    public static void main(String[] args) {
        // Valores iniciales y parámetros del método
        double x0 = 0.0;    // Valor inicial de x
        double y0 = 1.0;    // Valor inicial de y
        double xEnd = 2.0;  // Valor final de x
        double step = 0.1;  // Tamaño del paso

        // Llamar al método de Euler
        euler(x0, y0, xEnd, step);
    }
}

//Entrada
// Ejemplo: f(x, y) = x * y^2.


//Salida (Resultado)
//x = 0.0000, y = 1.0000
//x = 0.1000, y = 1.0000
//x = 0.2000, y = 1.0100
//x = 0.3000, y = 1.0304
//x = 0.4000, y = 1.0623
//x = 0.5000, y = 1.1074
//x = 0.6000, y = 1.1687
//x = 0.7000, y = 1.2507
//x = 0.8000, y = 1.3601
//x = 0.9000, y = 1.5081
//x = 1.0000, y = 1.7129
//x = 1.1000, y = 2.0062
//x = 1.2000, y = 2.4490
//x = 1.3000, y = 3.1687
//x = 1.4000, y = 4.4740
//x = 1.5000, y = 7.2763
//x = 1.6000, y = 15.2179
//x = 1.7000, y = 52.2715
//x = 1.8000, y = 516.7634
//x = 1.9000, y = 48584.7592
//x = 2.0000, y = 448539562.2005