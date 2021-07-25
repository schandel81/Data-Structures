import java.util.*;

//Add one to array.
public class AddOne {
    public static void main(String[] args) {
        ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(9, 9, 9));
        int sum = 0;
        int carry = 1;
        int itr = inputArray.size() - 1;
        while (itr >= 0) {
            sum = inputArray.get(itr) + carry;
            if (sum > 9) {
                inputArray.set(itr, sum % 10);
                carry = sum / 10;
            } else
                break;
            itr--;
        }
        if (sum > 9) {
            inputArray.add(carry);
            Collections.swap(inputArray, 0, inputArray.size() - 1);
        }
        System.out.println(inputArray);
    }
}
