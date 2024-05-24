package Problemario;

public class MetodoDePasosMultiples5 {
    // Definición de la función f(t, y)
    public static double f(double t, double y) {
        // Ejemplo: dy/dt = t * Math.sqrt(y)
        return t * Math.sqrt(y);
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
        return y1 + h * (0.5 * (fp + f(t1, y1)));
    }

    public static void main(String[] args) {
        // Condiciones iniciales
        double t0 = 0.0;
        double y0 = 1.0;
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
// Ejemplo: dy/dt = t * Math.sqrt(y)


//Salida (Resultado)
//t = 0.0, y = 1.0
//t = 0.1, y = 1.0
//t = 0.2, y (predictor) = 1.015, y (corrector) = 1.015074720839805
//t = 0.30000000000000004, y (predictor) = 1.0402999958386503, y (corrector) = 1.0404490771637
//t = 0.4, y (predictor) = 1.0762750680691453, y (corrector) = 1.076498173578264
//t = 0.5, y (predictor) = 1.1234504706954547, y (corrector) = 1.1237472961938013
//t = 0.6, y (predictor) = 1.1825016209818073, y (corrector) = 1.1828719002365324
//t = 0.7, y (predictor) = 1.2542540863613536, y (corrector) = 1.254697594620063
//t = 0.7999999999999999, y (predictor) = 1.3396835691901763, y (corrector) = 1.3402001244569068
//t = 0.8999999999999999, y (predictor) = 1.4399158901349167, y (corrector) = 1.4405053524799716
//t = 0.9999999999999999, y (predictor) = 1.5562269709573866, y (corrector) = 1.5568892402506773