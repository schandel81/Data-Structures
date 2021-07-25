import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stack1 {
    boolean parenthesisChecker(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        Character c = null;
        while(i < s.length()) {
            switch(s.charAt(i)) {
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '}':
                    c = stack.pop();
                    if(c != '}')
                        return false;
                    break;
                case ')':
                    c = stack.pop();
                    if(c != ')')
                        return false;
                    break;
                case ']':
                    c = stack.pop();
                    if(c != ']')
                        return false;
                    break;
                default:
                    break;
            }
            i++;
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
    void nextGretestElement(ArrayList<Integer> inputArray) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(inputArray.get(0));
        Integer next = null;
        for(int i = 1; i < inputArray.size(); i++) {
            next = inputArray.get(i);
            while(!s.isEmpty()) {
                int top = s.peek();
                if(top < next) {
                    System.out.println("NGE for " + top + " is " + next);
                    s.pop();
                }
                else
                    break;
            }
            s.push(next);
        }
        while(!s.isEmpty()) {
            System.out.println("NGE for " + s.pop() + " is " + -1);
        }
    }
    static void celebrityProblem(ArrayList<ArrayList<Integer> > knows, int n) {
        int start = 0;
        int end = n-1;
        while(start != end) {
            if (knows.get(start).get(end) == 1)
                start++;
            else if (knows.get(end).get(start) == 1)
                end--;
            else if (knows.get(start).get(end) == 0)
                end--;
            else if (knows.get(end).get(start) == 0)
                start++;
        }
        int i = 0;
        for(i = 0; i < n; i++) {
            if(knows.get(i).get(start) == 1 && knows.get(start).get(i) == 0 || (i == start))
                continue;
            else
                break;
        }
        if(i == n)
            System.out.println("Celebrity is :" + start);
        else
            System.out.println("No Celebrity");
    }
    static void stockSpan(ArrayList<Integer> stock) {

        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        ArrayList<Integer> span = new ArrayList<Integer>(stock.size());
        for(int x : stock)
            span.add(-1);
        span.set(0,1);
        for(int i = 1; i < stock.size(); i++) {
            while(!st.isEmpty() && stock.get(st.peek()) <= stock.get(i))
                st.pop();
            span.set(i,st.empty() ? (i + 1): i - st.peek());
            st.push(i);
        }
        System.out.println(span);
    }
    static void maxHistogramRectangle(ArrayList<Integer> hist) {
        Stack<Integer> st = new Stack<Integer>();
        int max_area = 0;
        int tp;
        int area_with_top;
        int i = 0;
        while(i < hist.size()){
            if(st.empty() || hist.get(st.peek()) <= hist.get(i))
                st.push(i++);
            else {
                tp = st.pop();
                area_with_top = hist.get(tp) * (st.empty() ? i : i - st.peek() - 1);
                if(area_with_top > max_area)
                    max_area = area_with_top;
            }
        }
        System.out.println(max_area);
    }
    static String removeKDigits(String num, int k) {
        StringBuilder result = new StringBuilder();
        if (k >= num.length())
            return "0";
        if (k == 0)
            return num;
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            if (!s.isEmpty() || c != '0')
                s.push(c);
        }
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String str = result.reverse().toString();

        return str;
    }
    //321 Geeky Buildings
    static boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack <Integer> stack = new Stack <Integer> ();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(6, 2, 5, 4, 5, 1, 6));
        maxHistogramRectangle(a);
        String s = "765028321";
        int k = 5;
        System.out.println(removeKDigits(s, 5));
        int arr[] = new int[]{4, 7, 11, 5, 13, 2};
        System.out.println(find132pattern(arr));
    }
}
