package Part04;


@FunctionalInterface
public interface MyFunction<T, U> {
    U apply(T t);

    default <V> MyFunction<V, U> compose(MyFunction<? super V, ? extends T> before) {
        return a -> apply(before.apply(a));
    }

}

