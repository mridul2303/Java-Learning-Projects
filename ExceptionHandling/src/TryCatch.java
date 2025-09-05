/*
basically the code which can produce exception write that in try block
and then write a catch block where we mention exception to handle exception
 */

public class TryCatch {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            System.out.println(a/b);
        }
        catch (Exception e ){
            System.out.println("write your own message " + e);
        }
    }
}
/*
there is an exception class which consists many subclass in which other
 exception classes are there.
 if we don't know about the particular exception then just mention the parent class
 which is Exception class
 */