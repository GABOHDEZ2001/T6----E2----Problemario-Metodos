package Problemario;

public class MetodoDePasosMultiples3 {
    // Definición de la función f(t, y)
    public static double f(double t, double y) {
        // Ejemplo: dy/dt = y + t
        return y + t;
    }

    // Método de Adams-Bashforth de 4 pasos
    public static double adamsBashforth4(double t0, double y0, double t1, double y1, double t2, double y2, double t3, double y3, double h) {
        double f0 = f(t0, y0);
        double f1 = f(t1, y1);
        double f2 = f(t2, y2);
        double f3 = f(t3, y3);
        return y3 + h * (55.0 / 24.0 * f3 - 59.0 / 24.0 * f2 + 37.0 / 24.0 * f1 - 9.0 / 24.0 * f0);
    }

    // Método de Adams-Moulton de 4 pasos (corrector)
    public static double adamsMoulton4(double t1, double y1, double t2, double y2, double t3, double y3, double t4, double h, double predictor) {
        double f1 = f(t1, y1);
        double f2 = f(t2, y2);
        double f3 = f(t3, y3);
        double fp = f(t4, predictor);
        return y3 + h * (9.0 / 24.0 * fp + 19.0 / 24.0 * f3 - 5.0 / 24.0 * f2 + 1.0 / 24.0 * f1);
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double t0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        int steps = 10;

        // Primeros tres pasos usando el método de Euler para obtener y1, y2 y y3
        double t1 = t0 + h;
        double y1 = y0 + h * f(t0, y0);
        double t2 = t1 + h;
        double y2 = y1 + h * f(t1, y1);
        double t3 = t2 + h;
        double y3 = y2 + h * f(t2, y2);

        System.out.println("t = " + t0 + ", y = " + y0);
        System.out.println("t = " + t1 + ", y = " + y1);
        System.out.println("t = " + t2 + ", y = " + y2);
        System.out.println("t = " + t3 + ", y = " + y3);

        // Pasos múltiples de Adams-Bashforth-Moulton
        for (int i = 4; i <= steps; i++) {
            double t4 = t3 + h;
            double predictor = adamsBashforth4(t0, y0, t1, y1, t2, y2, t3, y3, h);
            double corrector = adamsMoulton4(t1, y1, t2, y2, t3, y3, t4, h, predictor);

            System.out.println("t = " + t4 + ", y (predictor) = " + predictor + ", y (corrector) = " + corrector);

            // Actualizar valores para el siguiente paso
            t0 = t1;
            y0 = y1;
            t1 = t2;
            y1 = y2;
            t2 = t3;
            y2 = y3;
            t3 = t4;
            y3 = corrector;
        }
    }
}
//Entrada
// Ejemplo: dy/dt = y + t


//Salida (Resultado)
//t = 0.0, y = 1.0
//t = 0.1, y = 1.1
//t = 0.2, y = 1.2200000000000002
//t = 0.30000000000000004, y = 1.362
//t = 0.4, y (predictor) = 1.5412916666666667, y (corrector) = 1.5417901041666668
//t = 0.5, y (predictor) = 1.752125336371528, y (corrector) = 1.7512615208604603
//t = 0.6, y (predictor) = 1.99279388545001, y (corrector) = 1.9931872014628165
//t = 0.7, y (predictor) = 2.27105845231221, y (corrector) = 2.271085390623099
//t = 0.7999999999999999, y (predictor) = 2.588719627841021, y (corrector) = 2.588728826397909
//t = 0.8999999999999999, y (predictor) = 2.950281410445835, y (corrector) = 2.950296079080909
//t = 0.9999999999999999, y (predictor) = 3.3603909050470038, y (corrector) = 3.36040684952505