public class NormalizeTheta {
    public static double normalize(double theta){
        int k;
        if (theta >= 2*Math.PI){
            k = (int) (theta / (2* Math.PI));
            theta -= k*2*Math.PI;
        } else if (theta <0){
            k = (int) (-theta / (2* Math.PI))+1;
            theta += k*2*Math.PI;
        }
        return theta;
    }
}
