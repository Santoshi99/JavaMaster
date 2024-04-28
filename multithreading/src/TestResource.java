import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestResource {
    private final Lock displayQueueLock = new ReentrantLock();
    private final Lock readQueueLock = new ReentrantLock();

    private int sum =0,res=0;
    public void displayRecord(Object document){
        final Lock displayLock = this.displayQueueLock;
        displayLock.lock();
        this.readQueueLock.lock();
        try{
            Long duration = (long) (Math.random()*10000);
            sum++;
            System.out.println(Thread.currentThread().getName()+":TestResource: display a job"+
            " during" +sum+"seconds::"+"Time-"+new Date());
            Thread.sleep(duration);
            res=sum;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            System.out.printf("%s: The document has been displayed\n", Thread.currentThread().getName());
            displayLock.unlock();
            this.readQueueLock.unlock();
        }
    }

    public void readRecord(Object document){
         //final Lock readQueueLock = this.readQueueLock;
         this.readQueueLock.lock();
         try{
             Long duration = (long) (Math.random()*10000);

             System.out.println(Thread.currentThread().getName()+":TestResource: read a job"+
                     " during" +res+"seconds::"+"Time-"+new Date());
             Thread.sleep(duration);
         }catch(InterruptedException e){
             throw new RuntimeException(e);
         }
         finally{
             System.out.printf("%s: The document has been read\n", Thread.currentThread().getName());
             this.readQueueLock.unlock();

         }
    }
}
