package numbers;

public class MathFormula {
    public static void main(String[] args) {
        /*
        System.out.println(calcPathVelocity(80, 3));
        System.out.println(calcCentripetalAccel(1.67, 80));
        System.out.println(calcCentripetalForce(0.2, 3.504));
         */

        System.out.println(calcCentripetalForce(0.2, 80, 3));
    }

    private static double calcPathVelocity(double radius, double period) {
        double circumferenceOfCircle = 2 * Math.PI * (radius / 100);
        return circumferenceOfCircle / period;
    }

    private static double calcCentripetalAccel(double pathVelocity, double radius) {
        return Math.pow(pathVelocity, 2) / (radius / 100);
    }

    private static double calcCentripetalForce(double mass, double acc) {
        return mass * acc;
    }

    public static double calcCentripetalForce(double mass, double radius, double period) {
        double pathVelocity = calcPathVelocity(radius, period);
        double centripetalAccel = calcCentripetalAccel(pathVelocity, radius);
        double centripetalForce = calcCentripetalForce(mass, centripetalAccel);

        return centripetalForce;
    }
}
