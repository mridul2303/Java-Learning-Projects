public class Table {
    public static void main(String[] args) {
        Table1 t = new Table1();
        Threadtable t1 = new Threadtable(t,5);
        t1.start();
        Threadtable t2 = new Threadtable(t,3);
        t2.start();
        System.out.println("Heya");

    }
}

class Table1 {
    synchronized void printtable(int n){    //we use synchronized by which if thread come to this function then this will executely completely
        for (int a = 0 ; a<=10; a++){
            System.out.println(a*n);
        }
    }
}

class Threadtable extends Thread{
    Table1 t1;
    int no1;
    Threadtable(Table1 t , int no){
        t1= t;
        no1 = no;
    }
    public void run(){//we use run method to call the function
        t1.printtable(no1);

    }

}

