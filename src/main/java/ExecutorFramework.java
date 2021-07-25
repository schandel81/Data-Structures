import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Scheduled : " + Thread.currentThread().getName());
    }
}
class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Scheduled at Fixed Rate : " + Thread.currentThread().getName());
    }
}
public class ExecutorFramework {
    public static void main(String args[]) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
            t1.start();
        //}
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core count: " + coreCount);
        ExecutorService exe = Executors.newFixedThreadPool(coreCount);
        ExecutorService exeCached = Executors.newCachedThreadPool();
        for(int i=0; i< 10; i++) {
            exeCached.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName());
                        }
                    });
        }
        ScheduledExecutorService se = Executors.newScheduledThreadPool(10);
        se.schedule(new Task(), 10, TimeUnit.SECONDS);
        se.scheduleAtFixedRate(new Task1(), 3, 2,TimeUnit.SECONDS);
        se.scheduleWithFixedDelay(new Task1(),3, 2 , TimeUnit.SECONDS);
        List<Integer> fl = Collections.synchronizedList(new ArrayList<>());
        fl.add(2);

    }
}
