import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Minimum Jumps required to reach the end
public class MinimumJumps {
    static int minimumJump(ArrayList<Integer> input) {
        ArrayList<Integer> jumps = new ArrayList<Integer>();
        for(int i = 0; i < input.size(); i++)
            jumps.add(Integer.MAX_VALUE);
        jumps.set(0,0);
        for(int i = 1; i < input.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(i <= j + input.get(j) && jumps.get(j) != Integer.MAX_VALUE) {
                    jumps.set(i, Math.min(jumps.get(j) + 1, jumps.get(i)));
                }
            }
        }
        return jumps.get(jumps.size() - 1);
    }
    public static void main(String[] args) {
        System.out.println("Minimum Jumps "+ minimumJump(new ArrayList<Integer>(Arrays.asList(1, 3, 6, 3, 2, 3, 6, 8, 9, 5))));
    }
}
