package Assignment7;

public class Fraction {
    private final double numerator;
    private final double denominator;

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        // If denominator is 0, set it to 1. To avoid division by zero exception
        this.denominator = denominator == 0 ? 1 : denominator;
    }

    public void printDetailsFraction(double numerator, double denominator) {
        System.out.printf("The fraction %.2f/%.2f has value %.2f\n", numerator, denominator, numerator / denominator);
    }

    public void getValue() {
        printDetailsFraction(numerator, denominator);
    }

    public double findGCD(double numerator, double denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return findGCD(denominator, numerator % denominator);
    }

    public void shortenFraction(double numeratorResult, double denominatorResult) {
        double gcd = findGCD(numeratorResult, denominatorResult);
        double shortenedNumerator = numeratorResult / gcd;
        double shortenedDenominator = denominatorResult / gcd;
        printDetailsFraction(shortenedNumerator, shortenedDenominator);
    }


    public void addFraction(Fraction other) {
        double numeratorResult;
        double denominatorResult;
        if (denominator == other.denominator) {
            numeratorResult = numerator + other.numerator;
            denominatorResult = denominator;
        } else {
            numeratorResult = (numerator * other.denominator) + (other.numerator * denominator);
            denominatorResult = denominator * other.denominator;
        }

        // Shorten fraction after addition
        shortenFraction(numeratorResult, denominatorResult);
    }

    public void subtractFraction(Fraction other) {
        double numeratorResult;
        double denominatorResult;
        if (denominator == other.denominator) {
            numeratorResult = numerator - other.numerator;
            denominatorResult = denominator;
        } else {
            numeratorResult = (numerator * other.denominator) - (other.numerator * denominator);
            denominatorResult = denominator * other.denominator;
        }

        // Shorten fraction after subtraction
        shortenFraction(numeratorResult, denominatorResult);
    }

    public void multiplyFraction(Fraction other) {
        double numeratorResult = numerator * other.numerator;
        double denominatorResult = denominator * other.denominator;

        // Shorten fraction after multiplication
        shortenFraction(numeratorResult, denominatorResult);
    }

    public void divideFraction(Fraction other) {
        double numeratorResult = numerator * other.denominator;
        double denominatorResult = denominator * other.numerator;

        // Shorten fraction after division
        shortenFraction(numeratorResult, denominatorResult);
    }

}
