package ru.pivovarov.customExecutor;

public class Main {

    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool(3);

        pool.submit(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() +  " HELLO FROM "+"A");
            }
        });

        pool.submit(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() +  " HELLO FROM "+"B");
            }
        });
 		pool.submit(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() +  " HELLO FROM "+"C");                
            }
        });

    }
}
