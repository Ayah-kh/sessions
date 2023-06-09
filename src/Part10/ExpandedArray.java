package Part10;

import Part05.Operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.function.Function.identity;

public class ExpandedArray<T> {

    private final static int DEFAULT_SIZE = 10;
    Object[] data = null;
    int lastIndex = 0;

    public ExpandedArray() {
        this(DEFAULT_SIZE);
    }

    public ExpandedArray(int initialSize) {
        this.data = new Object[initialSize];
    }

    public static <T> ExpandedArray<T> of(T... data) {
        ExpandedArray<T> expandedArray = new ExpandedArray<>(data.length);
        for (T e : data) {
            expandedArray.addElement(e);
        }
        return expandedArray;
    }

    public ExpandedArray<T> addElement(T element) {
        if (lastIndex >= data.length) {
            expandData();
        }
        data[lastIndex++] = element;
        return this;
    }

    public T getElementByIndex(int index) {
        return (T) data[index];
    }

    public boolean removeElementByIndex(int index) {
        if (index < 0 || index >= lastIndex) {
            return false;
        }
        for (int i = index; i < lastIndex - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--lastIndex] = null;
        return true;
    }

    public boolean removeByValue(T element) {
        for (int i = 0; i < lastIndex; i++) {
            if (data[i].equals(element)) {
                return removeElementByIndex(i);
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(data[i] + "  ");
        }
        System.out.println();
    }


    public void forEach(Operation<T> operation) {
        for (int i = 0; i < lastIndex; i++) {
            operation.doOperation((T) data[i]);
        }
    }

    private void expandData() {
        data = Arrays.copyOf(data, data.length * 2);
    }


    public <U> Map<U, ExpandedArray<T>> grouping(Function<T, U> keyExtractor) {

//        return reduceL(
//                new HashMap<>(),
//                acc->e->{
//                    U key = keyExtractor.apply(e);
//                    acc.compute(key, (k,l)->{
//                      if(l == null){
//                          l=new ExpandedArray<>();
//                      }
//                      l.addElement(e);
//                      return l;
//                    });
//                    return acc;
//                });

//        return grouping(keyExtractor, t->t);
        return grouping(keyExtractor, identity());

    }

    public <U, V> Map<U, ExpandedArray<V>> grouping(Function<T, U> keyExtractor, Function<T, V> valueExtractor) {
        return reduceL(new HashMap<>(), acc -> e -> {
            U key = keyExtractor.apply(e);
            acc.compute(key, (k, l) -> {
                if (l == null) {
                    l = new ExpandedArray<>();
                }
                l.addElement(valueExtractor.apply(e));
                return l;
            });
            return acc;
        });
    }

    public ExpandedArray<T> filter(Predicate<T> filterFunction) {
        return reduceL(new ExpandedArray<>(), acc -> e -> filterFunction.test(e) ? acc.addElement(e) : acc

        );
    }

    public <U> ExpandedArray<U> map(Function<T, U> mappedFunction) {
        return reduceL(new ExpandedArray<>(data.length), acc -> e -> acc.addElement(mappedFunction.apply(e)));
    }

    public <U> U reduceR(U seed, CBIFunction<T, U, U> accFunction) {
        return reduceR(seed, accFunction, lastIndex - 1);

//        U result = seed;
//        for (int i = lastIndex - 1; i >= 0; i--) {
//            result=accFunction.apply((T)data[i]).apply(result);
//        }
//        return result;
    }

    private <U> U reduceR(U acc, CBIFunction<T, U, U> accFunction, int i) {

        return i < 0 ?
                acc :
                reduceR(
                        accFunction.apply(getElementByIndex(i)).apply(acc),
                        accFunction,
                        i - 1);

    }

    public <U> U reduceL(U seed, CBIFunction<U, T, U> accFunction) {

        return reduceL(seed, accFunction, 0);
    }

    private <U> U reduceL(U acc, CBIFunction<U, T, U> accFunction, int i) {
        //TODO We still didn't resolve stack overflow exception if the data is too big
        //TCE or TCO
        return i >= lastIndex ? acc : reduceL(accFunction.apply(acc).apply(getElementByIndex(i)), accFunction, i + 1);
    }


    @Override
    public String toString() {
        return "ExpandedArray{" + "data=" + Arrays.toString(data) + '}';
    }

    public <U> U myReduceL(U seed, CBIFunction<U, T, U> accFunction) {
        return myReduceL(seed, accFunction, 0);
    }

    private <U> U myReduceL(U acc, CBIFunction<U, T, U> accFunction, int i) {
        return i >= lastIndex
                ? acc
                : reduceL(
                        accFunction.apply(acc).apply(getElementByIndex(i)),
                        accFunction,
                        i + 1);
    }

    public <U> U myReduceR(U seed,CBIFunction<T,U,U> accFunction){
        return myReduceR(seed,accFunction,lastIndex-1);

    }

    private <U> U myReduceR(U acc  , CBIFunction<T,U,U> accFunction, int i) {
        return i<0
                ?acc
                :myReduceR(
                        accFunction.apply(getElementByIndex(i)).apply(acc),
                accFunction,
                i-1);
    }

    public <U> ExpandedArray<U> myMap(Function<T,U> function){
       return reduceL(new ExpandedArray<U>(),
                acc->e->acc.addElement(function.apply(e))
               );
    }

    public ExpandedArray<T> myFilter (Predicate<T> predicate){
        return reduceL(new ExpandedArray<T>(),
                   acc->e->predicate.test(e)?
                           acc.addElement(e)
                           :acc
                );
    }

//    public <U> Map<U,ExpandedArray<T>> myGrouping(Function<T,U> keyExtractor){
//        return reduceL(new HashMap<>(),
//                acc->e->{
//                    U key = keyExtractor.apply(e);
//                    acc.compute(key,(k,l)->{
//
//                    })
//
//                });
//    }
}
