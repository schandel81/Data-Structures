import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class testClass {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        m1.put("Sandeep", "Chandel");
        m1.put("Anshuman", "Chandel");
        if(m1.containsKey("Anshuman"))
            m1.put("Ishaan", "Chandel");
        //System.out.println(m1);
        System.out.println(m1.toString());
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.stream().filter(x-> x == 1).collect(Collectors.toList());
        System.out.println(l1);
    }
}
