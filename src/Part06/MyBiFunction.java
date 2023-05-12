package Part06;

@FunctionalInterface
public interface MyBiFunction<T,U,V> {
    V apply(T t,U u);

    default CBiFunction<T,U,V> convert(){
        return t -> u -> apply(t,u);
    }

}
