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

}

