import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
//Majority Element, occurrence greater than N/2
public class MajorityElement {
    public static void main(String args[]) {
        ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(3, 1, 3, 3, 2));
        System.out.println(inputArray);
        Hashtable<Integer, Integer> frequencyCount = new Hashtable<Integer, Integer>();
        for (int x : inputArray) {
            if (frequencyCount.containsKey(x)) {
                if (frequencyCount.get(x) + 1 > (inputArray.size() / 2)) {
                    System.out.println("Key Found : " + x);
                    break;
                }
                frequencyCount.put(x, frequencyCount.get(x) + 1);
            } else
                frequencyCount.put(x, 1);
        }
        System.out.println(frequencyCount);
    }
}
