package Part04;

import java.util.function.IntFunction;

@FunctionalInterface
public interface MyIntFunction {
    Integer apply(Integer a);

    default MyIntFunction compose(MyIntFunction before){
        return a->apply(before.apply(a));
    }
    default MyIntFunction compose2(MyIntFunction before){
        return a-> {
            Integer applyFirst = before.apply(a);
            return apply(applyFirst);
        };
        }
    }


