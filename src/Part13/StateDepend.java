package Part13;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StateDepend {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Iterator<Integer> numIterator = numbers.iterator();

        while (numIterator.hasNext()){
            try {
                Integer num = numIterator.next();
                System.out.println("num = " + num);
            }catch (NoSuchElementException e){
                break;
            }
        }
    }

}
