package ru.pivovarov.customExecutor;

import java.util.Deque;
import java.util.LinkedList;

public class ThreadPool {

    private PoolWorker [] threads;
    private Deque<Runnable> tasks ;

    public ThreadPool (int threadsCount) {
        tasks = new LinkedList<>();
        threads=new PoolWorker[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i]= new PoolWorker();
            threads[i].start();
        }
    }
    public void submit (Runnable task){
        synchronized (tasks){
            tasks.add(task);
            tasks.notify();
        }
    }
    private  class PoolWorker extends Thread {

        @Override
        public void run() {
            System.out.println("in RUN");
            while (true) {
                synchronized(tasks) {
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                    Runnable instruction = tasks.removeFirst();
                    instruction.run();
                }
            }
        }
    }
}
