import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment_4 {
    public static void main(String[] args) {

        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();

    }


    private static void Bai1() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter a integer n from 1 => 15");
        int n = scanner1.nextInt();

        // Traverse for every row in the expected triangle result
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.printf("%d ", j);
            }

            for (int k = 2; k <= i; k++) {
                System.out.printf("%d ", k);
            }
            System.out.println();
        }
    }

}
