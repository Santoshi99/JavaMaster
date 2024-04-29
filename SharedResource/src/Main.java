//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
         int maxIncrements = 10000;
        int numThreads = 6;
        Thread[] threads = new Thread[numThreads];

        for(int i =0;i<numThreads;i++){
            threads[i] = new Thread(new IncrementThread(counter,maxIncrements));
            threads[i].start();
        }
        for(int i =0;i<numThreads;i++){
          try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Final count: " + counter.getCount());

    }
}