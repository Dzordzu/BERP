package logic;

/**
 * Represents all type of builders. It is recommended for every instance of the implementation of this interface
 * to be a singleton to prevent multithreaded addition in the context of the one process;
 * @param <ReturnType> Type of built target;
 */

public interface Builder<ReturnType> {
    void clear();
    ReturnType build();
    ReturnType buildAndClear();
}
