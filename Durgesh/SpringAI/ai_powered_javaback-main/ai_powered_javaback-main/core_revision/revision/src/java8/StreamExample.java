package java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.IO.*;

public class StreamExample {
    void main() {
        println("stream example...");
        println("start with stream api example..");
        System.out.println("working file..");
        //modifiable list:
        List<Integer> numberList = new ArrayList<>();
        numberList.add(123);
        numberList.add(34);
        numberList.add(235);
        numberList.add(7854);
        System.out.println(numberList);

        //unmodifiable list
        List<Integer> numbers = List.of(12, 23, 45, 56);
        System.out.println(numbers);

        // stream to process my list:
//
//        Stream<Integer> stream = numberList.stream();
//        System.out.println(stream.count());

        long count = numberList
                .stream()
                .count();
        System.out.println("count of number list : " + count);

        //add 5 to every element of list:
        List<Integer> listWithAddition5 = numbers
                .stream()
                .map((item) -> item + 5)
                .toList();

        System.out.println(listWithAddition5);


        //List--> fetch all even numbers:
        List<Integer> listWithEvenNumbers = numbers.stream()
                .filter(item -> item % 2 == 0)
                .toList();
        System.out.println(listWithEvenNumbers);

        // 2 operations
        //square>>> plus 2>>> even numbers


        List<Integer> resultOp1 = numbers
                .stream()
                .map(item -> item * item)
                .map(item -> item + 2)
                .filter(item -> item % 2 == 0)
                .toList();

        System.out.println(resultOp1);

        //flatMap example:
        List<List<String>> students = List.of(
                List.of("ravi", "ankit", "saurabh", "vivek"),
                List.of("reena", "divya", "ankita", "soniya")
        );

        List<Character> studentList = students
                .stream()
                .flatMap(Collection::stream)
                .map(item-> item.charAt(0))
                .map(Character::toUpperCase)
                .toList();
        System.out.println(studentList);


    }
}
