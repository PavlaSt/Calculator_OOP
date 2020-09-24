public class Division implements Operation {

    @Override
    public double calculate(double a, double b) {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("Wrong input - when dividing, the divisor must be non-zero.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("! Chybný vstup - při dělení musí být dělitel různý od nuly!");
        }

        return a / b;
    }



}
