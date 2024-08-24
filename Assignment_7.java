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

        // Bai 3
        System.out.println("*****************************************");
        Bai3();
        System.out.println("*****************************************");

        System.out.println();
    }

    private static class Circle {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    private static void Bai1() {
        Circle circle = new Circle(5);
        System.out.println("Circumference of the circle is " + circle.getCircumference());
        System.out.println("Area of the circle is " + circle.getArea());

    }

    private static class Fraction {
        private final double numerator;
        private final double denominator;

        public Fraction(double numerator, double denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
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

        public void shortenFraction() {
            double gcd = findGCD(numerator, denominator);
            double shortenedNumerator = numerator / gcd;
            double shortenedDenominator = denominator / gcd;
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
            double gcd = findGCD(numeratorResult, denominatorResult);
            numeratorResult = numeratorResult / gcd;
            denominatorResult = denominatorResult / gcd;

            printDetailsFraction(numeratorResult, denominatorResult);
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
            double gcd = findGCD(numeratorResult, denominatorResult);
            numeratorResult = numeratorResult / gcd;
            denominatorResult = denominatorResult / gcd;

            printDetailsFraction(numeratorResult, denominatorResult);
        }

        public void multiplyFraction(Fraction other) {
            double numeratorResult = numerator * other.numerator;
            double denominatorResult = denominator * other.denominator;

            // Shorten fraction after multiplication
            double gcd = findGCD(numeratorResult, denominatorResult);
            numeratorResult = numeratorResult / gcd;
            denominatorResult = denominatorResult / gcd;

            printDetailsFraction(numeratorResult, denominatorResult);
        }

        public void divideFraction(Fraction other) {
            double numeratorResult = numerator * other.denominator;
            double denominatorResult = denominator * other.numerator;

            // Shorten fraction after division
            double gcd = findGCD(numeratorResult, denominatorResult);
            numeratorResult = numeratorResult / gcd;
            denominatorResult = denominatorResult / gcd;

            printDetailsFraction(numeratorResult, denominatorResult);
        }

    }

    private static void Bai2() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(4, 6);

        System.out.println("Get details information of some fractions");
        fraction1.getValue();
        fraction3.getValue();
        System.out.println();

        System.out.println("Shorten fraction");
        fraction3.shortenFraction();
        System.out.println();

        System.out.println("Add, subtract, multiply and divide between fractions 1 and 2");
        fraction1.addFraction(fraction2);
        fraction1.subtractFraction(fraction2);
        fraction1.multiplyFraction(fraction2);
        fraction1.divideFraction(fraction2);
    }

    private static class Student {
        private final String FullName;
        private final String Address;
        private final String Email;
        private final String PhoneNumber;
        private final String ID;

        public Student() {
            this.FullName = "Full Name Example";
            this.Address = "Address Example";
            this.Email = "Email Example";
            this.PhoneNumber = "Phone Number Example";
            this.ID = "ID Example";
        }

        public Student(String FullName, String Address, String Email, String PhoneNumber, String ID) {
            this.FullName = FullName;
            this.Address = Address;
            this.Email = Email;
            this.PhoneNumber = PhoneNumber;
            this.ID = ID;
        }

        public void GetDetailsStudentWithAction(String action) {
            System.out.printf("The full details of the student is FullName: %s,\tAddress: %s,\tEmail: %s,\tPhone Number: %s,\tID: %s is %s\n", FullName, Address, Email, PhoneNumber, ID, action);
        }

        public void Study() {
            GetDetailsStudentWithAction("studying");
        }

        public void DoHomework() {
            GetDetailsStudentWithAction("doing homework");
        }

        public void PayTuitionFee() {
            GetDetailsStudentWithAction("paying tuition fee");
        }

        public void Test() {
            GetDetailsStudentWithAction("testing");
        }
    }

    private static void Bai3() {
        // Default student constructing without parameters
        Student student1 = new Student();
        student1.Study();
        student1.DoHomework();
        student1.PayTuitionFee();
        student1.Test();

        System.out.println();

        // Student constructing with parameters
        Student student2 = new Student("ABC", "Address", "test@gmail.com", "1234567778899", "B22DCCN175");
        student2.Study();
        student2.DoHomework();
        student2.PayTuitionFee();
        student2.Test();
    }
}
