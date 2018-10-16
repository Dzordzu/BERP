package logic;

public interface Builder<ReturnType> {
    void clear();
    ReturnType build();
    ReturnType buildAndClear();
}
