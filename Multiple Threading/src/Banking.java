public class Banking {
    public static void main(String[] args) {
        CustomerClass c = new CustomerClass();


        new Thread(() -> c.withdrawl(15000)).start();
        new Thread(() -> c.deposit(10000)).start();

    }
}

class CustomerClass extends Thread{
    int amount = 20000;//available balance

    synchronized public void withdrawl(int amount)//15000
    {
        System.out.println("initial balance =" + this.amount);
        if (this.amount < amount) {
            System.out.println("not enough balance , wait for deposit");
            try {
                wait();// pauses the thread and releases the lock
            } catch (Exception e) {

            }
            this.amount -= amount;
            System.out.println("Withdraw completed! balance"+this.amount);
        }

    }
        synchronized void deposit(int amount){
            // Only deposit if balance is insufficient for withdrawal
            if (this.amount >= 15000) {
                System.out.println("Deposit not needed, balance is sufficient: " + this.amount);
                return; // Skip deposit
            }
        System.out.println("initial balance =" + this.amount);
        System.out.println("going to deposit");
        this.amount += amount;
        System.out.println("deposit completed");
        System.out.println("amount after deposit"+ this.amount);
        notify();// Wakes up a waiting thread

    }

    }
