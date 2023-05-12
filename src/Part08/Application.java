package Part08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        Stream.of(students)
                .forEach(student -> System.out.println(student));

        Stream.of(students)
                .map(Student::getName)
                .forEach(System.out::println);

        System.out.println("=============================================");

        Stream.of(students)
                .filter(Student::isActive)
                .forEach(System.out::println);

        System.out.println("=============================================");

        Stream<Course> courseStream = Stream.of(students)
                .flatMap(student -> student.getCourse().stream());

        Stream<Stream<Course>> streamStream = Stream.of(students)
                .map(student -> student.getCourse().stream());

        List<String> studentsName = Stream.of(students)
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("studentsName = " + studentsName);
        System.out.println("=============================================");

        Map<Gender, List<Student>> collect = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getGender));

        System.out.println("collect = " + collect);
        System.out.println("=============================================");

        Map<Gender, List<String>> collect1 = Stream.of(students)
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println("collect1 = " + collect1);

        System.out.println("=============================================");

        Stream.of(students)
                .map(Student::getName)
                .sorted()
                .forEach(System.out::println);

        Stream<String> stringStream = Stream.of(students)
                .map(Student::getName);

        int sum = IntStream.rangeClosed(1, 10)
                .reduce(0, (acc, e) -> acc + e);
        System.out.println("=============================================");
        System.out.println("sum = " + sum);



    }
}
