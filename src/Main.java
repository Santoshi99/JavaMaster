//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int MAX_NUMBER = 20;
    private static boolean isEven = true;
    private static  Object lock = new Object();
    public static void main(String[] args)  {

//        Sender sender = new Sender();
//        JavaThreadCreation thread1 = new JavaThreadCreation("Hi",sender);
//        thread1.start();//thread1.setPriority(10);
//
//        JavaThreadCreation thread2 = new JavaThreadCreation("Bye",sender);
//        thread2.start();
//        System.out.println(thread2.getPriority());
//       JavaThreadCreation thread3 = new JavaThreadCreation();
//      thread3.start();
//        System.out.println(thread3.getPriority());
//        RunnableExample thread4 = new RunnableExample();
//        thread4.run();
        //thread4.getPriority();
//        try {
//            thread1.join();
//            thread2.join();
//        }catch (InterruptedException e){
//           throw new RuntimeException();
//        }
//        for(int i =0;i<10;i++)
//        System.out.println(Thread.currentThread().getName()+"Hello World!!");




        // ReentrantLock Main Block

//        TestResource testResource = new TestResource();
//        Thread thread[] = new Thread[10];
//        for(int i =0;i<5;i++){
//            thread[i] = new Thread(new DisplayJob(testResource)
//            ,"Thread"+i);
//        }
//        for(int i =5;i<10;i++){
//            thread[i] = new Thread(new ReadJob(testResource)
//                    ,"Thread"+i);
//        }
//        for(int i =0;i<10;i++){
//            thread[i].start();
//        }


        //Even Odd Threads

        Thread evenThread = new Thread(()-> {
                for (int i = 0; i < MAX_NUMBER; i += 2) {
                    synchronized (lock) {
                        while(!isEven){
                            try{
                                lock.wait();
                            }
                            catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    System.out.println(i);
                        isEven = false;
                        lock.notify();
                }
            }
        });
        Thread oddThread = new Thread(()->{
        for(int i =1;i<MAX_NUMBER;i+=2){
            synchronized (lock) {
                while (isEven) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                isEven = true;
                lock.notify();
            }
            }});
        evenThread.start();
        oddThread.start();
    }
}