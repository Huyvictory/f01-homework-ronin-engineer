import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Assignment_5 {
    public static void main(String[] args) throws FileNotFoundException {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("*****************************************");
        System.out.println();
    }

    private static void Bai1() {
        int[] arrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = 0;
        for (int number : arrayNumbers) {
            sum += number;
        }

        System.out.println("The sum of the array is " + sum);
    }

}

