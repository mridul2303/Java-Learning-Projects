/*Exceptions are basically runtime errors
when our code do not have any syntactical errors but have hum inner issue like diving
number by 0 and searching in out of index in an array
so these are called exceptions
 */
public class Exceptions {
    public static void main(String[] args) {
        int a = 4;
        int b = 0;
        System.out.println(a/b);
    }
}
/*
we can handle these exceptions by writing code in try block and handle exception in
catch block

 */