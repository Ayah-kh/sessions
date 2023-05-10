package Part05;

import java.util.ArrayList;

public class Application2 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 7, 2, 33, 12, 5, 4};
        Iteration.forEach(arr,i-> System.out.println(i));


    }
}
class PrintOperation implements Operation{

    @Override
    public void doOperation(Object o) {
        System.out.println("Operation implemented "+o);
    }
}
class ToArrayListOperation implements Operation{
    ArrayList<Object> data=new ArrayList<>();


    @Override
    public void doOperation(Object o) {
        data.add(o);
    }
}
