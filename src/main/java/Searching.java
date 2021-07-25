import java.util.ArrayList;
import java.util.Arrays;

public class Searching {
    static int searchAndInsert(ArrayList<Integer> input, Integer k) {
        int index = input.indexOf(k);
        int start = 0;
        int end = input.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(input.get(mid) == k) {
                System.out.println("found at position: " + mid);
            }
            else if(input.get(mid) > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end+1;
    }
    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[start]) {
                if(nums[mid] >= target && nums[start] <= target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if(nums[mid] <= nums[end]) {
                if(nums[mid] <= target && nums[end] >= target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    static String convert(String s, int numRows) {
        ArrayList<ArrayList<Character> > list2D = new ArrayList<ArrayList<Character> >();
        if(numRows == 1)
            return s;
        int len = s.length();
        int i = 0;
        int r = 0, c = 0;
        int rmax = 0, cmax = 0;
        int gap = numRows - 2;
        boolean odd = true;

        while(true) {
            if(odd) {
                r = 0;
                while(i < len && r < numRows) {
                    if(c == 0) {
                        list2D.add(new ArrayList<Character>(Arrays.asList(s.charAt(i))));
                    }
                    else {
                        ArrayList<Character> rowValues = list2D.get(r);
                        rowValues.add(s.charAt(i));
                        list2D.set(r, rowValues);
                    }
                    r++;
                    i++;
                }
            }
            if(i == len)
                break;
            c = 1;
            odd = !odd;
            if(!odd) {
                r = gap;
                while(r > 0 && i < len) {
                    ArrayList<Character> rowValues = list2D.get(r);
                    rowValues.add(s.charAt(i));
                    list2D.set(r, rowValues);
                    r--;
                    i++;
                }
                odd = !odd;
            }
            if(i == len)
                break;
            // arr[r][c]

        }
        StringBuilder output = new StringBuilder();
        for(int x = 0; x < list2D.size(); x++)
        {
            for(Character c1 : list2D.get(x))
                output.append(c1);
        }

        return output.toString();
    }
    public static void main(String args[]) {
        System.out.println(searchAndInsert(new ArrayList<Integer>(Arrays.asList(1 , 3, 5, 6)), 2));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}