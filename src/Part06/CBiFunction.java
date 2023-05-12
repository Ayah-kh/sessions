package Part06;

@FunctionalInterface
public interface CBiFunction<T,U,V> extends MyFunction<T,MyFunction<U,V>>{

//MyFunction<U,V> apply(T t)
}
