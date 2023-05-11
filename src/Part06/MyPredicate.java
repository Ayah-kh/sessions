package Part06;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
