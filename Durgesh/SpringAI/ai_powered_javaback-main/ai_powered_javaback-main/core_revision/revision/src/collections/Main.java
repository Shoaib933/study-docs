package collections;

import java.sql.Array;
import java.util.*;

public class Main {
    void main() {
        Student student1 = new Student("om", 10, "123");
        Student student2 = new Student("hari", 14, "567");
        Student student3 = new Student("prakash", 12, "890");
        Student student4 = new Student("divya", 120, "741");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        List<Student> studentsCollection = new Vector<>();

        studentsCollection.add(student1);
        studentsCollection.add(student2);
        studentsCollection.add(student3);
        studentsCollection.add(student4);
        System.out.println(studentsCollection);


        for (Student student : studentsCollection) {
            System.out.println(student.getName());
        }

        Set<Student> studentsSet = new HashSet<>(studentsCollection);
//        TreeSet
        // LinkedHashSet
//        studentsCollection.addAll(studentsCollection);

        System.out.println(studentsSet);


    }
}
