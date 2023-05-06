package Part04;

@FunctionalInterface
public interface MyIntFunction {
    Integer apply(Integer a);

    default MyIntFunction compose(MyIntFunction before) {
        return a -> apply(before.apply(a));
    }

    default MyIntFunction compose2(MyIntFunction before) {
        return a -> {
            Integer applyFirst = before.apply(a);
            return apply(applyFirst);
        };
    }
}


