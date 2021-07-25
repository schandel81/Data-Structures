import java.util.*;
public class MedianOfTwoSortedArrays {
    static int median(ArrayList<Integer> l1, ArrayList<Integer> l2)
    {
        boolean even = ((l1.size() + l2.size()) % 2 == 0) ? true : false;
        int medpos = (l1.size() + l2.size()) / 2;
        int i = 0, j = 0;
        int len = -1;
        int prev = -1;
        ArrayList<Integer> out = new ArrayList<Integer>();
        while(i < l1.size() && j < l2.size())
        {
            if(l1.get(i) <= l2.get(j)) {
                out.add(l1.get(i));
                i++;
            }
            else {
                out.add(l2.get(j));
                j++;

            }
            len++;
            if(len == medpos)
            {
                if(!even)
                    return out.get(len);
                else
                    return ((out.get(len-1) + out.get(len))/2);
            }
        }
        return 0;
    }
    public static void main(String args[]){
        System.out.println("Median : " + median(new ArrayList<Integer>(Arrays.asList(1, 7, 10, 15, 20)), new ArrayList<Integer>(Arrays.asList(3,5, 8,9,12,14,18))));
    }
}
