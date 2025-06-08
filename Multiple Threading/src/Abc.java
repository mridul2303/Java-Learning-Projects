class  Account
{
    synchronized void deposite(int amount)//5000
    {
        int  balance=  getBalance();//10000
        balance=balance+amount;
        updateBalance(balance);
    }

    int getBalance()
    {

        return Abc.balance;//10000
    }

    void updateBalance(int balance)
    {

        Abc.balance=balance;

    }
}

class DepositeThread  extends Thread
{
    Account account;
    int amount;


    DepositeThread(Account account,int amount)
    {
        this.account=account;
        this.amount=amount;
        start();
    }

    public void run()
    {
        account.deposite(amount);
    }
}



class  Abc
{

    static  int   balance=10000;
    public static void main(String[] args)
    {

        Account account=new  Account();
        DepositeThread t1= new DepositeThread(account,5000);
        DepositeThread t2 =new DepositeThread(account,7000);

        try{

            t1.join();
            t2.join();
        }catch(InterruptedException   e)
        {

        }




        System.out.println("Final balance "+balance);
    }
}