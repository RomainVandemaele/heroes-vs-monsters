package bf.java.ex.delegate;

@FunctionalInterface
public interface Action<T> {
    void execute(T obj);
}
