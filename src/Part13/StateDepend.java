package Part13;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StateDepend {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Iterator<Integer> iterator = numbers.iterator();

        while (true){
            Integer num = iterator.next();
            System.out.println("num = " + num);
        }
    }

}
