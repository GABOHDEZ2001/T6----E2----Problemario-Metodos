package Problemario;

public class MetodoDePasosMultiples2 {
    // Definición de la función f(t, y)
    public static double f(double t, double y) {
        // Ejemplo: dy/dt = -2t * y^2
        return -2 * t * y * y;
    }

    // Método de Adams-Bashforth de 3 pasos
    public static double adamsBashforth3(double t0, double y0, double t1, double y1, double t2, double y2, double h) {
        double f0 = f(t0, y0);
        double f1 = f(t1, y1);
        double f2 = f(t2, y2);
        return y2 + h * ((23.0 / 12.0) * f2 - (16.0 / 12.0) * f1 + (5.0 / 12.0) * f0);
    }

    // Método de Adams-Moulton de 3 pasos (corrector)
    public static double adamsMoulton3(double t1, double y1, double t2, double y2, double t3, double h, double predictor) {
        double f1 = f(t1, y1);
        double f2 = f(t2, y2);
        double fp = f(t3, predictor);
        return y2 + h * ((5.0 / 24.0) * fp + (19.0 / 24.0) * f2 - (5.0 / 24.0) * f1);
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double t0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int steps = 10;

        // Primeros dos pasos usando el método de Euler para obtener y1 y y2
        double t1 = t0 + h;
        double y1 = y0 + h * f(t0, y0);
        double t2 = t1 + h;
        double y2 = y1 + h * f(t1, y1);

        System.out.println("t = " + t0 + ", y = " + y0);
        System.out.println("t = " + t1 + ", y = " + y1);
        System.out.println("t = " + t2 + ", y = " + y2);

        // Pasos múltiples de Adams-Bashforth-Moulton
        for (int i = 3; i <= steps; i++) {
            double t3 = t2 + h;
            double predictor = adamsBashforth3(t0, y0, t1, y1, t2, y2, h);
            double corrector = adamsMoulton3(t1, y1, t2, y2, t3, h, predictor);

            System.out.println("t = " + t3 + ", y (predictor) = " + predictor + ", y (corrector) = " + corrector);

            // Actualizar valores para el siguiente paso
            t0 = t1;
            y0 = y1;
            t1 = t2;
            y1 = y2;
            t2 = t3;
            y2 = corrector;
        }
    }
}

//Entrada
//Ejemplo: dy/dt = -2t * y^2


//Salida (Resultado)
//t = 0.0, y = 1.0
//t = 0.1, y = 1.0
//t = 0.2, y = 0.98
//t = 0.30000000000000004, y (predictor) = 0.933036, y (corrector) = 0.9428720477838
//t = 0.4, y (predictor) = 0.8835241624572181, y (corrector) = 0.895637266344667
//t = 0.5, y (predictor) = 0.8277524115846749, y (corrector) = 0.8416715492842567
//t = 0.6, y (predictor) = 0.7692319677933025, y (corrector) = 0.7841655017392308
//t = 0.7, y (predictor) = 0.7104508580465345, y (corrector) = 0.7257854928000241
//t = 0.7999999999999999, y (predictor) = 0.6533063573374631, y (corrector) = 0.6685483334789348
//t = 0.8999999999999999, y (predictor) = 0.5990651705768248, y (corrector) = 0.6138397975952925
//t = 0.9999999999999999, y (predictor) = 0.5484669059962295, y (corrector) = 0.5625104624395606