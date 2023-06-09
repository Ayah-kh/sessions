package Part05;

import Part04.MyFunction;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        MyBiFunction<Integer,Integer,Integer> add=(a,b)->a+b;
        System.out.println("add.apply(5,10) = " + add.apply(5, 10));

        MyBiFunction<Integer,Integer, Integer> multy=(a,b)->a*b;
        System.out.println("multy.apply(3,4) = " + multy.apply(3, 4));

        MyBiFunction<Integer,String,String> value=(a,b)->b+a;
        System.out.println("value.apply(3,\"My value is \") = " + value.apply(3, "My value is "));

        MyCurBiFunction<Integer,Integer,Integer> addCur=
        a->b->a+b;
        System.out.println("addCur.apply(3).apply(4) = " + addCur.apply(3).apply(4));
        MyFunction<Integer, Integer> add1 = addCur.apply(3);
        System.out.println("add1.apply(4) = " + add1.apply(4));
        MyCurBiFunction<Integer, Integer, Integer> add3 = convert(add);
        System.out.println("add3.apply(4).apply(5) = " + add3.apply(4).apply(5));
        System.out.println("--------------------");
        MyCurBiFunction<Integer,Integer,Integer> MultCurr=a->b->a*b;
        System.out.println("MultCurr.apply(3).apply(4) = " + MultCurr.apply(3).apply(4));
        MyBiFunction<Integer, Integer, Integer> MultiBi = convert(MultCurr);
        System.out.println("MultiBi.apply(3,4) = " + MultiBi.apply(3, 4));


    }


    static <T,U,V> MyCurBiFunction<T,U,V> convert (MyBiFunction<T,U,V> biFunction){
        return a->b->biFunction.apply(a,b);
    }
    static <T,U,V> MyBiFunction<T,U,V> convert (MyCurBiFunction<T,U,V> biCurFunction){
        return (a,b)->biCurFunction.apply(a).apply(b);
    }

    static  class Add implements MyCurBiFunction<Integer,Integer,Integer>{

        @Override
        public MyFunction<Integer, Integer> apply(Integer a) {
            return b->a+b;
        }
    }
}
