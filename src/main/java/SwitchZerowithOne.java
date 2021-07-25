import java.util.*;
import java.util.stream.*;
import java.lang.*;
//Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
class ArrayElement {
    int left;
    int right;
    ArrayElement(int left, int right)
    {
        this.left = left;
        this.right = right;
    }
}
public class SwitchZerowithOne
{

    public static void main(String[] args) {
        ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1));
        int m = 2;
        LinkedHashMap<Integer, ArrayElement> zero = new LinkedHashMap<Integer, ArrayElement>();
        int left = 0, right = 0;
        for(int i = 0; i < inputArray.size(); i++)
        {
            if(inputArray.get(i) == 1) {
                left++;
            }
            if(inputArray.get(i) == 0) {
                zero.put(i, new ArrayElement(left, 0));
                left = 0;
            }
        }
        for(int j = inputArray.size() - 1; j >= 0; j--)
        {
            if(inputArray.get(j) == 1) {
                right++;
            }
            if(inputArray.get(j) == 0) {
                zero.put(j, new ArrayElement(zero.get(j).left, right));
                right = 0;
            }
        }

        List<Integer> zeroIndex = zero.keySet().stream().collect(Collectors.toList());
        int maxOneCount = 0;
        for(int i = 0; i < zeroIndex.size(); i++)
        {
            int mCount = 0;
            int j = i;
            int curOneCount = zero.get(zeroIndex.get(j)).left;
            while(mCount < m && j < zeroIndex.size())
            {
                curOneCount+= zero.get(zeroIndex.get(j)).right;
                mCount++;
                j++;
            }
            if(curOneCount > maxOneCount)
                maxOneCount = curOneCount;
        }
        System.out.println(maxOneCount + m); //Important
    }

}