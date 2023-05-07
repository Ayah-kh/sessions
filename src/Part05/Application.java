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

    }
}
