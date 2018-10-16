package gui;

/**
 * Generalize generators of the content. Returns Type object, but should never
 * redirect, change content or manipulate state of the app
 * @param <Type>
 */

public interface ContentGenerator<Type> {
    Type generate();
}
