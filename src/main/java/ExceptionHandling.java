import java.io.IOException;
import java.util.*;
import java.lang.Exception;
class A {
    void getException(){
        throw new RuntimeException("IO Exception");
    }
}
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            (new A()).getException();
        }
        catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("Continuing Execution");
    }
}
