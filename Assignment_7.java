import Assignment7.Circle;

public class Assignment_7 {

    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        Circle circle = new Circle(5);
        System.out.println("Circumference of the circle is " + circle.getCircumference());
        System.out.println("Area of the circle is " + circle.getArea());
    }
}
