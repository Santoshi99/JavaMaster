import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private Date date;
    private double balance;
    private Lock lock;

    BankAccount(){
        balance = 0.0;
        lock = new ReentrantLock();
        date = new Date();
    }

    void deposit(double balance){

        System.out.println("deposit" + date.getTime()+Thread.currentThread().getName());
        this.lock.lock();
        try{
            this.balance += balance;
            System.out.println("deposit" + this.balance+date.getTime());
        }finally {
            this.lock.unlock();
        }
    }

    void withdraw(double balance){
        System.out.println("withdraw" + date.getTime()+Thread.currentThread().getName());
        this.lock.lock();
        try{
            if(this.balance>=balance) {
                this.balance -= balance;
                System.out.println("withdraw" + this.balance+date.getTime());
            }
            else{
                System.out.println("Insufficient funds");
            }
        }finally {
            this.lock.unlock();
        }
    }
}
