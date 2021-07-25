import java.util.*;
import java.util.stream.Collectors;

class Person {
    int id;
    String firstname;
    String secondname;
    Person(int id, String firstname, String secondname) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
    }
}
public class StreamDemo {
    public static void main(String args[]) {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Gupta");
        Person alex = new Person(3, "Alex", "Kolen");
        ArrayList<Person> al1 = new ArrayList<Person>();
        al1.addAll(Arrays.asList(lokesh, brian, alex));
        List<String> out = al1.stream().map(x -> x.secondname).distinct().collect(Collectors.toList());
        System.out.println(out);
        List<Double> ll1 = new ArrayList<Double>(Arrays.asList(1d, 2d, 3d ,4d ,5d));
        Double sum = ll1.stream().mapToDouble(i -> i).reduce(0, (a, b)-> a + b);
        System.out.println(sum);
        Double average = ll1.stream().mapToDouble(i -> i).average().getAsDouble();
        System.out.println(average);
    }
}
