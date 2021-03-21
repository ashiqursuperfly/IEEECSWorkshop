package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Progress {
    
    StringBuilder sb;

    public Progress() {
        sb = new StringBuilder();
    }

    synchronized public void postProgress(String tid, int progress) {
        sb.append(tid).append(progress).append("--");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
};

public class WorkerWithSharedResource implements Runnable {

    public Thread thread;
    public String id;
    public List<Integer> data;
    public final Progress progressUpdate;

    public int result;

    public WorkerWithSharedResource(String id, List<Integer> data, Progress sharedRes) {
        this.data = data;
        this.id = id;
        progressUpdate = sharedRes;
        thread = new Thread(this);
    }

    @Override
    public void run() {

        for (int i = 0; i < data.size(); i++) {
            result += data.get(i);

            if (i % 3333 == 0) {
                progressUpdate.sb.append(id).append(i * 100/ 10000).append("--");
                // progressUpdate.postProgress(id, i * 100/ 10000);
                /*synchronized (progressUpdate) {
                    progressUpdate.sb.append(id).append(i * 100/ 10000).append("--");
                }*/
            }
        }
    }
}

class ThreadSyncDemo {

    static List<Integer> generateRandomArray(int size) {

        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            data.add(i);
        }

        Collections.shuffle(data);

        return data;
    }

    public static void main(String[] args) {

        Progress sharedRes = new Progress();

        List<Integer> data = generateRandomArray(50000);

        WorkerWithSharedResource [] workers = new WorkerWithSharedResource[5];
        for (int i = 0; i < 5; i++) {
            workers[i] = new WorkerWithSharedResource((char)(i + 'a')+"", data.subList(i*10000, i*10000 + 10000), sharedRes);
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i].thread.start();
        }

        for (int i = 0; i < workers.length; i++) {
            try {
                workers[i].thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Parallel Result:"+ (workers[0].result + workers[1].result + workers[2].result + workers[3].result + workers[4].result));

        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            result += data.get(i);
        }
        System.out.println("Sequential Result:"+ result);
        System.out.println(sharedRes);
        System.out.println("End Of Main Thread Execution");

    }
}

