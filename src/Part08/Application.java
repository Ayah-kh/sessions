package Part08;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    static Student[] students = new Student[]{
            Student.of("Ahmad", 20, Gender.MALE, true, Course.MATH, Course.CHEMISTRY, Course.JAVA),
            Student.of("Mohammad", 25, Gender.MALE, true, Course.MATH, Course.JAVA),
            Student.of("ESA", 27, Gender.MALE, false, Course.MATH, Course.JAVA),
            Student.of("ESRA", 19, Gender.FEMALE, true, Course.MATH, Course.ENGLISH),
            Student.of("DANA", 40, Gender.FEMALE, true, Course.MATH, Course.ENGLISH, Course.PHYSICS),
            Student.of("RUBA", 22, Gender.FEMALE, true, Course.MATH, Course.PHYSICS)
    };

    public static void main(String[] args) {
        Optional<Student> first = Stream.of(students)
                .filter(student -> student.getAge() < 15)
                .findFirst();

        System.out.println("first = " + first);

        Optional<Student> first1 = Stream.of(students)
                .filter(student -> student.getAge() > 15)
                .findFirst();

        System.out.println("first1 = " + first1);

        List<Student> orderStudents = Stream.of(students)
                .sorted()
                .collect(Collectors.toList());
        Stream.of(students)
                .sorted(Comparator.comparingInt(Student::getAge).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++++++++++++++++");

        List<Student> orderStudent2 = Stream.of(students)
                .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .collect(Collectors.toList());

        orderStudent2.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        Stream.of(students)
                .sorted(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);




    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static Optional<Integer> divideV2(int a, int b) {
        return b == 0 ?
                Optional.empty()
                : Optional.of(a / b);
    }
}
