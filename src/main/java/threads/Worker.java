package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Worker implements Runnable {

    public Thread thread;
    public String id;
    public List<Integer> data;

    public int result;

    public Worker(String id, List<Integer> data) {
        this.data = data;
        this.id = id;
        thread = new Thread(this);
    }

    @Override
    public void run() {

        for (int i = 0; i < data.size(); i++) {
            result += data.get(i);
            /*System.out.println("Thread:" + id + " working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
       // System.out.println("Thread:" + id + " Exited");

    }
}

class ThreadDemo {

    static List<Integer> generateRandomArray(int size) {

        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            data.add(i);
        }

        Collections.shuffle(data);

        return data;
    }

    public static void main(String[] args) {

        List<Integer> data = generateRandomArray(50000);

        Worker [] workers = new Worker[5];
        workers[0] = new Worker(0+"", data.subList(0, 10000));
        workers[1] = new Worker(1+"", data.subList(10000, 20000));
        workers[2] = new Worker(2+"", data.subList(20000, 30000));
        workers[3] = new Worker(3+"", data.subList(30000, 40000));
        workers[4] = new Worker(4+"", data.subList(40000, 50000));

        for (int i = 0; i < workers.length; i++) {
            workers[i].thread.start();
            // workers[i].thread.join();
        }

        System.out.println("Parallel Result:"+ (workers[0].result + workers[1].result + workers[2].result + workers[3].result + workers[4].result));

        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            result += data.get(i);
        }
        System.out.println("Sequential Result:"+ result);
        System.out.println("End Of Main Thread Execution");

    }
}
