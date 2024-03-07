package numbers;

public class Rational {
    private int numerator;
    private int denominator;

    // Constructor
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); // Simplify the fraction upon creation
    }

    // Method to simplify the rational number
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            // Ensure the negative sign is always on the numerator
            numerator *= -1;
            denominator *= -1;
        }
    }

    // Method to calculate the greatest common divisor
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Method to add two rational numbers
    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Method to subtract two rational numbers
    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Method to multiply two rational numbers
    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Method to divide two rational numbers
    public Rational divide(Rational other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    // Method to get a string representation of the rational number
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(1, 2);

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);

        Rational sum = r1.add(r2);
        System.out.println("Sum: " + sum);

        Rational difference = r1.subtract(r2);
        System.out.println("Difference: " + difference);

        Rational product = r1.multiply(r2);
        System.out.println("Product: " + product);

        Rational quotient = r1.divide(r2);
        System.out.println("Quotient: " + quotient);
    }
}
