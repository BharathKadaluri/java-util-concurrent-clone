package mamu.util.concurrent;

// Declare as functional interface so that one method
// will be present in the interface
@FunctionalInterface
public interface Runnable {
    void run();
}
