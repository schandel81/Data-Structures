import java.util.ArrayList;
import java.util.Arrays;

public class LargeFactorial {
    static void multiply(ArrayList<Integer> res, int x) {
        int carry = 0;
        int product = 1;
        for(int i = 0; i < res.size(); i++) {
            product = (res.get(i) * x) + carry;
            res.set(i, product % 10);
            carry = product / 10;
        }
        while(carry != 0) {
            res.add( carry % 10);
            carry = carry / 10;
        }
    }
    public static void main(String args[]) {
        ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(1));
        int x = 100;
        for(int i = 1; i <= 100; i++)
            multiply(res, i);
        for(int i = res.size()-1; i >= 0; i--) {
            System.out.print(res.get(i));
        }


    }
}
