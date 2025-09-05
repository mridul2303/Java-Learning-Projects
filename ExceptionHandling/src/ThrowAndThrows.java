public class ThrowAndThrows {
    public static void main(String[] args) throws Exception {
        divByZero(1,0);
    }

    static int divByZero(int a , int b) throws Exception {
        if (b == 0) throw new Exception("can't div by zero");
        int c = a / b;
        return c;
    }
}
/*
throw — actually throws an exception object at runtime:
throws — method declaration that says the method may
         throw these checked exceptions, so callers must handle or declare them:
 */

