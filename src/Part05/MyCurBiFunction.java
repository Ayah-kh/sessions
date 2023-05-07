package Part05;

import Part04.MyFunction;

@FunctionalInterface
public interface MyCurBiFunction<T,U,V> extends MyFunction<T,MyFunction<U,V>>{
    //a->b-> do what you want with a and b
//    MyFunction<U,V> apply(T t);


}
