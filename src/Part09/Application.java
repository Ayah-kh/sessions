package Part09;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Integer sum = reduceL(0, acc -> e -> acc + e, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer max = max(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max);
    }


    public static <U, T> U
    reduceL(U seed, Function<U, Function<T, U>> acc, T... data) {

        if (data == null || data.length == 0)
            return seed;
        U accRes = seed;

        for (int i = 0; i < data.length; i++) {
            accRes = acc.apply(accRes).apply(data[i]);
        }

        return accRes;
    }

    public static <U, T> U reduceR
            (U seed, Function<U, Function<T, U>> accFunction, T... data) {
        if (data == null || data.length == 0)
            return seed;
        U accRes = seed;
        for (int i = data.length; i > 0; i--) {
            accRes = accFunction.apply(accRes).apply(data[i]);
        }
        return accRes;
    }

    public static int max(Integer... data) {
        return reduceL(0, acc -> e -> acc > e ? acc : e,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
