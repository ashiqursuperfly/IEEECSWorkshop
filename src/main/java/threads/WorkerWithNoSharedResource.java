package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerWithNoSharedResource implements Runnable {

    public Thread thread;
    public String id;
    public List<Integer> data;

    public int result;

    public WorkerWithNoSharedResource(String id, List<Integer> data) {
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

        WorkerWithNoSharedResource[] workers = new WorkerWithNoSharedResource[5];
        for (int i = 0; i < 5; i++) {
            workers[i] = new WorkerWithNoSharedResource(i+"", data.subList(i*10000, i*10000 + 10000));
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i].thread.start();
        }

        /*for (int i = 0; i < workers.length; i++) {
            workers[i].thread.join();
        }*/

        System.out.println("Parallel Result:"+ (workers[0].result + workers[1].result + workers[2].result + workers[3].result + workers[4].result));

        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            result += data.get(i);
        }
        System.out.println("Sequential Result:"+ result);
        System.out.println("End Of Main Thread Execution");

    }
}
