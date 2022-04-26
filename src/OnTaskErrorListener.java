@FunctionalInterface
public interface OnTaskErrorListener<T, N> {
    N onError(T t);
}
