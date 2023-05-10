package Part05;

public class Iteration {
    public static <T> void forEach(T[] array,
                                   Operation<T> operation) {
        for (T i : array) {
            operation.doOperation(i);
        }
        }
    }

