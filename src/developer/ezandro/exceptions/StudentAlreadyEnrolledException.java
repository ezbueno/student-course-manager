package developer.ezandro.exceptions;

public class StudentAlreadyEnrolledException extends RuntimeException {
    public StudentAlreadyEnrolledException(String message) {
        super(message);
    }
}