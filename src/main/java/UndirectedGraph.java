import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edge {
    Integer src;
    Integer dest;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}
public class UndirectedGraph {
    public static int find(Map<Integer, Integer> parent, int x) {
        if(!parent.containsKey(x))
            return x;
        return find(parent, parent.get(x));
    }
    public static int findWithCompression(Map<Integer, Integer> parent, int x) {
        if(parent.containsKey(x)) {
            parent.put(x, findWithCompression(parent, parent.get(x)));
        }
        if(!parent.containsKey(x))
            return x;
        else
            return parent.get(x);
    }
    public static void unionWithRank(Map<Integer, Integer> parent, int x, int y, Map<Integer, Integer> rank) {
        if(!rank.containsKey(x))
            rank.put(x,0);
        if(!rank.containsKey(y))
            rank.put(y,0);
        if(rank.get(x) < rank.get(y))
            parent.put(x,y);
        else if(rank.get(x) > rank.get(y))
            parent.put(y,x);
        else {
            Integer i = rank.get(y);
            i++;
            rank.put(y, i);
            parent.put(x,y);
        }
    }
    public static void union(Map<Integer, Integer> parent, int x, int y) {
        parent.put(x,y);
    }
    public static boolean detectLoop(List<Edge> graph) {
        Map<Integer, Integer> parent = new HashMap<>();
        for(Edge e : graph) {
            int srcParent = find(parent, e.src);
            int destParent = find(parent, e.dest);
            if(srcParent == destParent)
                return true;
            union(parent, srcParent, destParent);
        }
        return false;
    }

    public static boolean detectLoopLowTimeComplexity(List<Edge> graph) {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        for(Edge e : graph) {
            int srcParent = findWithCompression(parent, e.src);
            int destParent = findWithCompression(parent, e.dest);
            if(srcParent == destParent)
                return true;
            unionWithRank(parent, srcParent, destParent,rank);
        }
        return false;
    }
    public static void main(String[] args) {
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(1,2));
        //graph.add(new Edge(1,3));
        graph.add(new Edge(2,4));
        graph.add(new Edge(3,4));
        graph.add(new Edge(5,6));
        graph.add(new Edge(5,7));
        //graph.add(new Edge(6,8));
        graph.add(new Edge(7,8));
        long startTime = System.nanoTime();
        System.out.println(detectLoop(graph));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime));
        long startTime1 = System.nanoTime();
        System.out.println(detectLoopLowTimeComplexity(graph));
        long endTime1 = System.nanoTime();
        System.out.println((endTime1 - startTime1));
    }
}
