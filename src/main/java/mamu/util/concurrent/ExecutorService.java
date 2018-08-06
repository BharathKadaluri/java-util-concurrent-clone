package mamu.util.concurrent;


import mamu.util.concurrent.exceptions.TaskRejectedException;

import java.util.Collection;
import java.util.List;

public interface ExecutorService extends Executor {

    /**
     *  Overview
     *                                __      __
     *  Queue  for storing tasks --> |_| --> |_|
     *
     *  Pool of thread/threads --> Each thread would pick from
     *  the Queue and execute the task
     *
     *  Handle these problems when handling De-queueing
     *
     *  Race, deadlock, starvation
     */

    //***********************************************************************
    // Submission tasks
    //***********************************************************************

    /**
     * Submit a callable and get the Future as a return
     * @param callable
     * @param <T>
     * @throws TaskRejectedException will be thrown when the task is rejected
     *                  a) this could happen when the Queue is full
     *                  c)
     * @return
     */
    <T> Future<T> submit(Callable<T> callable) throws TaskRejectedException;

    /**
     * Support for Runnable as well
     * T will always be null ?? Fix
     */
    Future<?> submit(Runnable runnable);


    /** Invoke list of callable tasks
     */

   <T> List<Future<T>>invokeAll(Collection<? extends Callable<T>> tasks);


    //***********************************************************************
    // Abort tasks, kill or shutdown
    //***********************************************************************

    /**
     *  Showdown Executor , gracefull , will complete all the
     *  tasks and shutdown
     */
     void shutDown();


    /**
     *  Hard kill -- abort all the tasks and return immediately,
     *  best effort and return the list of incomplete tasks
     *
     */
    List<Runnable> shutDownNow();




}
