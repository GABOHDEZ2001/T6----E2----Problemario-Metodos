package Problemario;

public class MetodoDePasosMultiples1 {
    // Definición de la función f(t, y)
    public static double f(double t, double y) {
        // Ejemplo: dy/dt = y - t^2 + 1
        return y - t * t + 1;
    }

    // Método de Adams-Bashforth de 2 pasos
    public static double adamsBashforth2(double t0, double y0, double t1, double y1, double h) {
        double f0 = f(t0, y0);
        double f1 = f(t1, y1);
        return y1 + h * (1.5 * f1 - 0.5 * f0);
    }

    // Método de Adams-Moulton de 2 pasos (corrector)
    public static double adamsMoulton2(double t0, double y0, double t1, double y1, double h, double predictor) {
        double f0 = f(t0, y0);
        double fp = f(t1 + h, predictor);
        double f1 = f(t1, y1);
        return y1 + h * (0.5 * (fp + f1));
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double t0 = 0.0;
        double y0 = 0.5;
        double h = 0.1;
        int steps = 10;

        // Primer paso usando el método de Euler para obtener y1
        double t1 = t0 + h;
        double y1 = y0 + h * f(t0, y0);

        System.out.println("t = " + t0 + ", y = " + y0);
        System.out.println("t = " + t1 + ", y = " + y1);

        // Pasos múltiples de Adams-Bashforth-Moulton
        for (int i = 2; i <= steps; i++) {
            double t2 = t1 + h;
            double predictor = adamsBashforth2(t0, y0, t1, y1, h);
            double corrector = adamsMoulton2(t0, y0, t1, y1, h, predictor);

            System.out.println("t = " + t2 + ", y (predictor) = " + predictor + ", y (corrector) = " + corrector);

            // Actualizar valores para el siguiente paso
            t0 = t1;
            y0 = y1;
            t1 = t2;
            y1 = corrector;
        }
    }
}



//Entrada
// Ejemplo: dy/dt = y - t^2 + 1


//Salida (Resultado)
//t = 0.0, y = 0.5
//t = 0.1, y = 0.65
//t = 0.2, y (predictor) = 0.8210000000000001, y (corrector) = 0.8210500000000001
//t = 0.30000000000000004, y (predictor) = 1.0062075, y (corrector) = 1.0059128750000002
//t = 0.4, y (predictor) = 1.20424730625, y (corrector) = 1.2039208840625002
//t = 0.5, y (predictor) = 1.4147133729218753, y (corrector) = 1.414352596911719
//t = 0.6, y (predictor) = 1.6368094422453519, y (corrector) = 1.6364106988695726
//t = 0.7, y (predictor) = 1.8696546738544226, y (corrector) = 1.8692139675057724
//t = 0.7999999999999999, y (predictor) = 2.1122755276881597, y (corrector) = 2.111788442265469
//t = 0.8999999999999999, y (predictor) = 2.3635960102300007, y (corrector) = 2.3630576648902424
//t = 0.9999999999999999, y (predictor) = 2.6224268925105054, y (corrector) = 2.6218318927602797
