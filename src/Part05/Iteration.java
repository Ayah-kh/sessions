package Part05;

public class Iteration {
    public static <T> void forEach(int[] array,
                                   Operation<T> operation) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("This " + array[i]);
        }
    }
}
