package mamu.util.concurrent;

@FunctionalInterface
public interface Callable<T> {
    //Callable that will return a result
    T call() throws Exception;

}
