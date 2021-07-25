import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Interview1 {
    static boolean canJump(int[] arr) {
        int maxReach = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i > maxReach)
                return false;
            maxReach = Math.max(arr[i] + i, maxReach);
            if(maxReach >= arr.length-1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
        System.out.println(canJump(arr));
    }
}