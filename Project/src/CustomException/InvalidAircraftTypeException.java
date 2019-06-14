package CustomException;

public class InvalidAircraftTypeException  extends Exception {
    public InvalidAircraftTypeException(String errorMessage) {
        super(errorMessage);
    }
}