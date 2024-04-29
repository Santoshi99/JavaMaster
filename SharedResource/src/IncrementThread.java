public class IncrementThread implements Runnable{

    private Counter counter;
    private int maxIncrements;
    public IncrementThread(Counter counter, int maxIncrements){
        this.counter=counter;
        this.maxIncrements = maxIncrements;
    }

    @Override
    public void run(){

        for(int i =0;i<maxIncrements;i++){
            counter.increment();
        }
    }
}
