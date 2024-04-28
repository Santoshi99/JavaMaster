public class Sender {

     public void send(String msg){
         System.out.println("Sending"+msg);
         try{
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         System.out.println(msg + "Sent");
     }


}
