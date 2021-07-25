import java.util.*;
import java.util.stream.Collectors;

public class DirectedGraph {
    public static void DFS(Map<Integer, LinkedHashSet<Integer>> graph, Set<Integer> visited, Integer start) {
        LinkedHashSet s = graph.get(start);
        if(!visited.contains(start)) {
            visited.add(start);
            System.out.println(start + " ");
        }
        if(s != null)
            s.forEach(x -> {if(!visited.contains(x)) DFS(graph, visited, (Integer)x);});
    }
    public static void toplogicalSort(Map<Integer, LinkedHashSet<Integer>> graph, Set<Integer> visited, Integer start, Stack<Integer> s1) {
        Set<Integer> s = graph.get(start);
        if(!visited.contains(start))
            visited.add(start);
        if(s != null)
            s.forEach(x -> {if(!visited.contains(x)) toplogicalSort(graph, visited, (Integer)x, s1);});
        s1.push(start);
    }
    public static boolean detectLoop(Map<Integer, LinkedHashSet<Integer>> graph, Set<Integer> visited, Set<Integer> recStack, int start) {
        Set<Integer> s = graph.get(start);
        if(recStack.contains(start))
            return true;
        if(visited.contains(start))
            return false;
        visited.add(start);
        recStack.add(start);
        if(s != null) {
            for(Integer x : s)
                if (detectLoop(graph, visited, recStack, x))
                    return true;
        }
        recStack.remove(start);
        return false;
    }
    public static void BFS(Map<Integer, LinkedHashSet<Integer>> graph, Set<Integer> visited, Integer start) {
        Queue q = new LinkedList<Integer>();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()) {
            Integer curr = (Integer)q.poll();
            System.out.println(curr);
            Set<Integer> s = graph.get(curr);
            if(s != null)
                s.forEach(x -> {if(!visited.contains(x)) {
                visited.add(x);
                q.add(x);
            }});
        }
    }
    public static void main(String[] args) {
        Map<Integer, LinkedHashSet<Integer>> graph = new HashMap<>();
        graph.put(0, new LinkedHashSet<Integer>());
        graph.get(0).add(10);
        graph.get(0).add(20);
        graph.get(0).add(30);
        graph.put(9, new LinkedHashSet<Integer>());
        graph.get(9).add(90);
        graph.get(9).add(100);
        graph.put(10, new LinkedHashSet<Integer>());
        graph.get(10).add(100);
        graph.put(90, new LinkedHashSet<Integer>());
        graph.get(90).add(20);
        graph.get(90).add(0);
        graph.put(100, new LinkedHashSet<Integer>());
        graph.get(100).add(0);
        System.out.println(graph);
        Set<Integer> keys =  graph.keySet();
        Set visited = new HashSet<>();
        System.out.println("DFS");
        for(Integer a : keys) {
            if(!visited.contains(a))
                DFS(graph, visited, a);
        }
        visited = null;
        visited = new HashSet<Integer>();
        System.out.println("BFS");
        for(Integer a : keys) {
            if(!visited.contains(a))
                BFS(graph, visited, a);
        }
        visited = null;
        visited = new HashSet<Integer>();
        Stack<Integer> s1 = new Stack<>();
        System.out.println("BFS");
        for(Integer a : keys) {
            if(!visited.contains(a))
                toplogicalSort(graph, visited, a, s1);
        }
        System.out.println("Toplogical Sort:");
        while(!s1.isEmpty())
            System.out.println(s1.pop());

        visited = null;
        visited = new HashSet<Integer>();
        System.out.println("BFS");
        for(Integer a : keys) {
            Set<Integer> s2 = new LinkedHashSet<>();
            if(!visited.contains(a))
                System.out.println(detectLoop(graph, visited, s2, a));
        }

    }
}
