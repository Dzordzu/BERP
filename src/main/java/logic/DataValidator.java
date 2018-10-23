package logic;

/**
 * API for any validator
 * @param <Type>
 */
public interface DataValidator<Type> {
    void validate(Type value) throws DataValidatorException;
}
