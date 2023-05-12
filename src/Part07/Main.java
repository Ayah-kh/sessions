package Part07;

import java.util.List;

public class Main {
    public static List<Person> createPeople() {
        return List.of(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("jack", Gender.MALE, 2),
                new Person("jack", Gender.MALE, 72),
                new Person("jill", Gender.FEMALE, 12)
        );
    }


    public static void main(String[] args) {
        List<Person> people = createPeople();
        List<String> names2 = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getName)
                .map(String::toUpperCase).toList();

        people.stream()
                .filter(person -> person.getGender() == Gender.MALE)
                .map(person -> new Person(person.getName().toUpperCase(),
                        person.getGender(), person.getAge()))
                .forEach(System.out::println);


    }
}
