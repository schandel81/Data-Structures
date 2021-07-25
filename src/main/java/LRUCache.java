import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    private static Map<String, String> values = new HashMap<>();
    private static Map<String, Integer> count = new HashMap<>();
    private static Map<Integer, LinkedHashSet<String>> fifo = new HashMap<>();
    private int capacity;
    private int min = 0;
     String get(String key) {
        if(!values.containsKey(key))
            return null;
        int cnt = count.get(key);
        count.put(key, count.get(key) + 1);
        fifo.get(cnt).remove(key);
        if(!fifo.containsKey(cnt + 1)) {
            fifo.put(cnt + 1, new LinkedHashSet<String>());
        }
        fifo.get(cnt + 1).add(key);
        fifo.put(cnt + 2, new LinkedHashSet<>());
        fifo.get(cnt + 2).add(key + 1);
        Set<Integer> s1 = fifo.keySet();
        return values.get(key);


    }

    }
}
