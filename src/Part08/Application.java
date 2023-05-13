package Part08;

import java.util.Optional;

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


        divideV2(4, 0)
                .map(a -> a * 3)
                .filter(a -> a % 2 == 0)
                .ifPresent(System.out::println);

        Integer integer = divideV2(4, 0)
                .map(a -> a * 3)
                .orElse(0);
        System.out.println("integer = " + integer);

        Integer integer2 = divideV2(4, 2)
                .map(a -> a * 4)
                .orElse(0);
        System.out.println("integer2 = " + integer2);


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
