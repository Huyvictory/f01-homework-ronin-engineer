import Assignment7.Circle;
import Assignment7.Fraction;

public class Assignment_7 {

    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        Circle circle = new Circle(5);
        System.out.println("Circumference of the circle is " + circle.getCircumference());
        System.out.println("Area of the circle is " + circle.getArea());
    }

    private static void Bai2() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(4, 6);
        Fraction fractionDenominatorZero = new Fraction(6, 0);

        System.out.println("Get details information of some fractions");
        fraction1.getValue();
        fraction3.getValue();
        fractionDenominatorZero.getValue();
        System.out.println();

        System.out.println("Shorten fraction");
        fraction3.shortenFraction(fraction3.getNumerator(), fraction3.getDenominator());
        System.out.println();

        System.out.println("Add, subtract, multiply and divide between fractions 1 and 2");
        fraction1.addFraction(fraction2);
        fraction1.subtractFraction(fraction2);
        fraction1.multiplyFraction(fraction2);
        fraction1.divideFraction(fraction2);
    }
}
