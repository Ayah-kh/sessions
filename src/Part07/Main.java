package Part07;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List.of(
                new Person("Sara",Gender.FEMALE,20),
                new Person("Sara",Gender.FEMALE,22),
                new Person("Bob",Gender.MALE,20),
                new Person("Paula",Gender.FEMALE,32),
                new Person("Paul",Gender.MALE,32),
                new Person("jack",Gender.MALE,2),
                new Person("jack",Gender.MALE,72),
                new Person("jill",Gender.FEMALE,12)
        );


    }
}
