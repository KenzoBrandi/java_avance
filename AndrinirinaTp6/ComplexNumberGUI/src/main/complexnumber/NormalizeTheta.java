package complexnumber;

/**
 * Classe utilitaire pour normaliser un angle {@code theta} en radians.
 * Elle s'assure que l'angle est compris dans l'intervalle [0, 2π[.
 */
public class NormalizeTheta {

    /**
     * Normalise un angle en radians pour qu'il soit compris dans l'intervalle [0, 2π[.
     *
     * @param theta l'angle en radians à normaliser.
     * @return l'angle normalisé, dans [0, 2π[.
     */
    public static double normalize(double theta) {
        int k;
        if (theta >= 2 * Math.PI) {
            k = (int) (theta / (2 * Math.PI));
            theta -= k * 2 * Math.PI;
        } else if (theta < 0) {
            k = (int) (-theta / (2 * Math.PI)) + 1;
            theta += k * 2 * Math.PI;
        }
        return theta;
    }
}
