package Part05;

import java.util.List;
import java.util.function.Predicate;

public interface Filter {
    List<Integer> filter
            (List<Integer> list,
             Predicate<Integer> predicate);
}
