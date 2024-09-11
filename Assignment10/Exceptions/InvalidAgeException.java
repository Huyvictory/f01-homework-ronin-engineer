package Assignment10.Exceptions;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super("Age should not be less than 18");
    }
}
