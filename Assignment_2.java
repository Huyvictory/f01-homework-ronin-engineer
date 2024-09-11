import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment_2 {
    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("******************************************");

        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("******************************************");

        System.out.println();
    }

    public static void Bai1() {
        double inchInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập so inch");
            inchInput = scanner.nextDouble();

        } while (inchInput <= 0);

        System.out.println("Số inch: " + inchInput + "được chuyển về " + inchInput * 2.54 + " cm");
    }

    public static double ChuyenDoNhietDo(String type, double temperature) {
        if (type.equalsIgnoreCase("C")) {

            return ((9.0 / 5) * temperature) + 32;
        }

        return (5.0 / 9) * (temperature - 32);
    }

    public static void Bai2() {
        Scanner scanner2 = new Scanner(System.in);
        String type;

        do {
            System.out.println("Nhập loại nhiệt độ F hoặc C");
            type = scanner2.nextLine();

        } while (!type.equalsIgnoreCase("F") && !type.equalsIgnoreCase("C"));

        System.out.println("Nhập nhiệt độ cần chuyển đổi");
        double temperature = scanner2.nextDouble();

        System.out.println("Nhiệt đột đả chuyển đổi từ " + type.toUpperCase() + " sang" + (type.equalsIgnoreCase("F") ? " C " : " F ") + ": " + ChuyenDoNhietDo(type, temperature));
    }

}

