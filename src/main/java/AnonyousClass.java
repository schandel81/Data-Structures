import java.util.*;

class Student {
    int rollno;
    int marks;
    String name;
    Student(int rollno, int marks, String name) {
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student Name : " + this.name + " Student marks : " + this.marks + " Student rollno : " + this.rollno + "\n";
    }
}
public class AnonyousClass {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(new Student(1, 50, "Sandeep"),
        new Student(2, 110, "Anshu"),
        new Student(3, 100, "Nirmal"),
        new Student(4, 80, "Amarjit")));

        class NameComparator implements Comparator<Student> {
            public int compare(Student s1, Student s2) {
                return s1.name.compareToIgnoreCase(s2.name);
            }
        }
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareToIgnoreCase(s2.name);
            }
        });
        System.out.println(studentList);
        Collections.sort(studentList, (s1, s2) -> {Integer i1 = s1.marks; Integer i2 = s2.marks; return i1.compareTo(i2);});


    }
}
