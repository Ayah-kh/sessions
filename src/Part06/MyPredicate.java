package Part06;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> another) {
        return t -> test(t) && another.test(t);
    }

    default MyPredicate<T> or(MyPredicate<T> another) {
        return t -> test(t) && another.test(t);
    }

    default MyPredicate<T> not() {
        return t -> !test(t);
    }
}
