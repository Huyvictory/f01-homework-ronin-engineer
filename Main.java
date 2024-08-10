//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // palindrome string check
        String palindrome = "abba";


        int j = palindrome.length() - 1;

        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != palindrome.charAt(j)) {
                System.out.println("Not a palindrome");
                return;
            }

            if (i >= j) {
                break;
            }
            j--;
        }

        System.out.println("Palindrome string");

    }
}