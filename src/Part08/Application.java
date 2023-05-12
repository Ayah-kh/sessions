package Part08;

import java.util.Arrays;
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



}
}
