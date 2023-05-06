package Part2;

public interface MyFunction<T,U> {
    public U apply (T t);

    default <V> MyFunction<V,U> compose(MyFunction<V,T> before){
        return x -> apply(before.apply(x));
    }

//    default <V> MyFunction<V,U> compose(MyFunction<V,T> before){
//return v -> {
//    T tValue = before.apply(v);
//    U result = apply(tValue);
//    return result;
//};
//    }



}
