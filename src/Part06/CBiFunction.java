package Part06;

import java.util.function.BiFunction;

@FunctionalInterface
public interface CBiFunction<T, U, V> extends MyFunction<T, MyFunction<U, V>> {

//MyFunction<U,V> apply(T t)

    default CBiFunction<U, T, V> flipParameters() {
        return u -> t -> apply(t).apply(u);
    }

    static<T,U,V> CBiFunction<T,U,V> convert(BiFunction<T,U,V> biFunction){
        return t -> u -> biFunction.apply(t,u);
    }

}
