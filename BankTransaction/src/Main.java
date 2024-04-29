//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

          BankAccount bankAccount = new BankAccount();
          Thread thread1 = new Thread(()-> bankAccount.deposit(1000));
          Thread thread2 = new Thread(()-> bankAccount.deposit(1600));
          Thread thread3 = new Thread(()-> bankAccount.withdraw(1000));
          Thread thread4 = new Thread(()-> bankAccount.withdraw(1800));

          thread1.start();
          thread2.start();
          thread3.start();
          thread4.start();
    }
}