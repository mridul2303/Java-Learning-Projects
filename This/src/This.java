public class This {
    public static void main(String[] args) {
        Math1 m1 = new Math1();
        Math2 m2 = new Math2();
        m1.printA(10,m2);


    }
}
    class Math1 {
        int a;

        void setA(int a1) {

        a =a1;
    }
    void printA(int a,Math2 m2){
        System.out.println(a);
        m2.PrintB(this,20);
    }

    }
class Math2 {
    int b;

    void setB(int b2) {
        b = b2;
    }
    void PrintB(Math1 m1,int b){
        System.out.println(b);

    }

}

