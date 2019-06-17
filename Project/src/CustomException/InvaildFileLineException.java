package CustomException;

public class InvaildFileLineException extends Exception {
    public InvaildFileLineException(String errorMessage) {
        super("line:"+"\""+errorMessage+"\""+", is not valid.");
    }
}
