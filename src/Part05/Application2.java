package Part05;

import java.util.ArrayList;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        Filter evenFilter= list -> {
            List<Integer> result=new ArrayList<>();
            for (Integer i : list) {
                if (i%2==0)
                    result.add(i);
            }
            return result;
        };

        Filter dividedBy7=list -> {
            List<Integer> result=new ArrayList<>();
            list.forEach(integer -> {
                if (integer%7==0)
                    result.add(integer);
            });

            return result;
        };

        List<Integer> input=List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> output= evenFilter.filter(input);
        System.out.println("output = " + output);
        System.out.println("+++++++++++++++++++++");
        List<Integer> output2 = dividedBy7.filter(input);
        System.out.println("output2 = " + output2);


    }
}
