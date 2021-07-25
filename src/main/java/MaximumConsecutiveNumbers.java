import java.util.*;
import java.util.stream.*;
import java.lang.*;

public class MaximumConsecutiveNumbers
{
    static int maximumConsecutive(ArrayList<Integer> input) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int x: input) {
            if(!hs.contains(x))
                hs.add(x);
        }
        int maxlen = 0;
        int curlen = 0;
        for(int x: input) {
            if(!hs.contains(x-1)) {
                int start = x;
                curlen = 0;
                while(hs.contains(start)) {
                    start++;
                    curlen++;
                }
            }
            if(curlen > maxlen)
                maxlen = curlen;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        System.out.println(maximumConsecutive(new ArrayList<Integer>(Arrays.asList(36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42))));
    }

}

