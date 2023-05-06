package Part04;

@FunctionalInterface
public interface MyFunction2<T, U> {
    U apply(T t);


    default <V> MyFunction2<V, U> compose2(MyFunction2<V, T> before) {
        return (V a) -> {
            T firstResult = before.apply(a);
            U finalResult = apply(firstResult);
            return finalResult;
        };
    }

    default <V> MyFunction2<V, U> compose(MyFunction2<? super V, ? extends T> before) {
        return a -> apply(before.apply(a));
    }

}

