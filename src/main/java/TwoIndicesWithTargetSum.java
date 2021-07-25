import java.util.ArrayList;
import java.util.Collections;
/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].*/
public class TwoIndicesWithTargetSum {


    static class ArrayIndex {
        int value;
        int index;

        ArrayIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15, 3, 10};
        //ArrayList<Integer> inpList = IntStream.of(input).boxed().collect(Collectors.toList());   //Collections.addAll(inpList, input);
        //Collections.sort(inpList);
        int sum = 17;
        ArrayList<ArrayIndex> list = new ArrayList<ArrayIndex>();
        int ind = 0;
        for (int x : input) {
            list.add(new ArrayIndex(x, ind++));
        }

        Collections.sort(list, (i, j) -> {
            if (i.value < j.value) return -1;
            else if (i.value > j.value) return 1;
            else return 0;
        });
        for (ArrayIndex a : list)
            System.out.println(a.value + " " + a.index);
        int end = list.size() - 1;
        int start = 0;
        while (start < end) {
            if (list.get(start).value + list.get(end).value == sum) {
                System.out.println("Found at indexes: " + list.get(start).index + " " + list.get(end).index);
                break;
            } else if (list.get(start).value + list.get(end).value < sum)
                start++;
            else
                end--;
        }
        if (start == end)
            System.out.println("Couldn't find");
    }


}
