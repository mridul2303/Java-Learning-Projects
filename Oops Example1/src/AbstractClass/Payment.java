package AbstractClass;

import java.util.Scanner;

public abstract class Payment {
    int amount;
    int balance;
    Scanner sc = new Scanner(System.in);
    Payment(int balance){
this.balance = balance;
    }
    abstract void pay();
}
//we do not make objects of abstract class
//usually don't make constructor also

class UPI extends Payment{
    UPI(int balance) {
        super(balance);//we need to call parent class constructor
    }
    void pay() {
        System.out.println("enter amount to pay");
        amount = sc.nextInt();
        balance -= amount;
        System.out.println("Payment Successful through UPI");
        System.out.println("available balance = " + balance);
    }

}
