package CustomException;

public class AircraftExistsException extends Exception {
    public AircraftExistsException(String errorMessage) {
        super(errorMessage+"\""+",  already exist.");
    }
}
