package mamu.util.concurrent;

import mamu.util.concurrent.exceptions.CancelledException;
import mamu.util.concurrent.exceptions.ExecutionException;
import mamu.util.concurrent.exceptions.InterruptedException;

import java.util.concurrent.TimeUnit;

public class FutureTask<T> implements RunnableFuture<T> {

    //States  (naming convention ???)
    /**
     * 1) NEW --> COMPLETING --> NORMAL
     * 2) NEW --> COMPLETING --> EXCEPTIONAL
     * 3) NEW --> CANCEL
     * 4) NEW --> INTERRUPTING --> INTERRUPTED
     */

    //Enumeration would have been nice ??
    private static final int NEW = 0;
    private static final int COMPLETING = 1;
    private static final int NORMAL = 2;
    private static final int EXCEPTIONAL = 3;
    private static final int CANCEL = 4;
    private static final int INTERRUPTING = 5;
    private static final int INTERRUPTED= 6;


    //Runnable AsycTask
    private Callable<T> callable; // function to be executed
    private Object result;


    //Maintain state
    private volatile int state;


    //Constructor
    public FutureTask(Callable<T> task){
        this.callable = task;
        //init state
        state = NEW;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException, CancelledException {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    @Override
    public T get(int timeout, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public void run() {
        //Run
    }
}
