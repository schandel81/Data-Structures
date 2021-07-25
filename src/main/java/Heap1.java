import java.util.*;
import java.util.stream.Collectors;


class Qnode{
    Character c;
    int freq;
    Qnode(Character c, int freq)
    {
        this.c = c;
        this.freq = freq;
    }
        }
public class Heap1 {
    static void rearrangeCharacters(String input) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        for(int i = 0; i < input.length(); i++) {
            if(h.containsKey(input.charAt(i)))
                h.put(input.charAt(i), h.get(input.charAt(i)) + 1);
            else
                h.put(input.charAt(i), 1);
        }
        PriorityQueue<Qnode> pq = new PriorityQueue<Qnode>((a, b) -> Integer.compare(b.freq,a.freq));
        List<Character> cl = h.keySet().stream().collect(Collectors.toList());
        for (Character c : cl)
            pq.add(new Qnode(c, h.get(c)));
        Character prev = null;
        StringBuilder output = new StringBuilder();
        while (!pq.isEmpty()) {
            Qnode q1 = pq.poll();
            if(prev != null && prev == q1.c) {
                Qnode q2 = pq.poll();
                output.append(q2.c);
                prev = q2.c;
                q2.freq--;
                if(q2.freq > 0)
                    pq.add(q2);
            }
            else {
                output.append(q1.c);
                prev = q1.c;
                q1.freq--;
            }
            if(q1.freq > 0)
                pq.add(q1);
            System.out.println(output);
        }

    }
    static void maximumRopesCost(ArrayList<Integer> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(Integer i : input)
            pq.add(i);
        Integer totalCost = 0;
        while(pq.size() > 1) {
            Integer rope1 = pq.poll();
            Integer rope2 = pq.poll();
            Integer ropeSum = rope1 + rope2;
            totalCost += ropeSum;
            pq.add(ropeSum);
        }
        System.out.println(totalCost);

    }
    static void kthLargestStream(ArrayList<Integer> input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < input.size(); i++) {
            if(i < k)
                pq.add(input.get(i));
            else {
                if(input.get(i) > pq.peek()) {
                    pq.poll();
                    pq.add(input.get(i));
                }
            }
        }
        System.out.println(pq.poll());
    }
    static void mergeKSortedArray(ArrayList<ArrayList<Integer> > input) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>(input.size());
        for(int i = 0; i < index.size(); i++)
            index.set(i, 0);

    }
    //Median of a stream
    public static void main(String args[]) {
        rearrangeCharacters("geeksforgeeks");
        maximumRopesCost(new ArrayList(Arrays.asList(4, 2, 7, 6, 9)));
        kthLargestStream(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6)), 4);
    }
}
