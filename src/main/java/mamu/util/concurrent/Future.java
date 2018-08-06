package mamu.util.concurrent;

import mamu.util.concurrent.exceptions.CancelledException;
import mamu.util.concurrent.exceptions.ExecutionException;
import mamu.util.concurrent.exceptions.InterruptedException;

import java.util.concurrent.TimeUnit;

public interface Future<T> {

    /**
     * Check if the task is still being completed or still in progress
     * will return True, if the work is still in progress else False
     * @return
     */
    boolean isDone();

    /**
     * Get the result of the Task
     * P.S while designing an abstraction, just keep in mind
     * what can go wrong(exceptions), not just the return types
     * ex: In this case Exceptions can happen when
     *           a) task is interrupted,
     *           b) task is cancelled
     *           c) the task is being executed, I/O, logic, etc
     */
    T get() throws InterruptedException,ExecutionException, CancelledException;


    /**
     * Cancel the task, will return True if successful else
     * False if can't cancel.
     * @return
     */
    boolean cancel();

    /**
     * Get the result, block for a specified unit of time, if not
     * return after specified period of time
     * //Cheat --> using Time unit from java.util.concurrent package
     * specify both the time and units
     * @return
     */
    T get(int timeout, TimeUnit timeUnit);
}
