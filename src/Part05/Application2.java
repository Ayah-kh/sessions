package Part05;

import java.util.ArrayList;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        Filter filter= (list,predicate)-> {
            List<Integer> result=new ArrayList<>();
            for (Integer i : list) {
                if (predicate.test(i))
                    result.add(i);
            }
            return result;
        };

//        Filter dividedBy7=list -> {
//            List<Integer> result=new ArrayList<>();
//            list.forEach(integer -> {
//                if (integer%7==0)
//                    result.add(integer);
//            });
//
//            return result;
//        };

        List<Integer> input=List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> evenOutput= filter.filter(input,integer -> integer%2==0);
        System.out.println("evenOutput = " + evenOutput);
        System.out.println("+++++++++++++++++++++");
        List<Integer> dividedBy7=filter.filter(input,integer -> integer%7==0);
        System.out.println("dividedBy7 = " + dividedBy7);

    }
}
