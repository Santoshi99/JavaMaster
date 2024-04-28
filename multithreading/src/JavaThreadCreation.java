public class JavaThreadCreation extends Thread{

    String msg;
    Sender sender;
    public JavaThreadCreation(String msg, Sender sender){
        this.msg = msg;
        this.sender = sender;
    }
 @Override
    public void run() {

//          // try {
//               for(int i =0;i<10;i++) {
//               //Thread.sleep(1000);
//                   System.out.println(Thread.currentThread().getName() + "Hello, World");
//               }
////           } catch (InterruptedException e) {
////               throw new RuntimeException(e);
////           }

              synchronized (this.sender){
                  sender.send(this.msg);
              }
    }
}
