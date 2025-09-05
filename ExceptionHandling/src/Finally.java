public class Finally {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            System.out.println(a/b);
        }
        catch (Exception e ){
            System.out.println("write your own message " + e);
        }
        finally {
            System.out.println("this block always executes");
        }
    }
}
/*
finally executes even if you return in try/catch. But if finally also has a return,
 that return overrides the one from try/catch.

 finally may not run in these cases:

When JVM halts via System.exit()
If the thread is killed abruptly (native)
If the JVM crashes (segfault)
If the computer loses power

overall finally executes if doesn't matter if exception is there or not
 */