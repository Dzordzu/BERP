package logic;

/**
 * Is thrown when data is improper (ex. numeric when the requirements specify alphabetical)
 */
public class DataValidatorException extends Exception {
    public DataValidatorException(String message) {
        super(message);
    }
}
