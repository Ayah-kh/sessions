package part3;

public interface MyInterface {

    default void myDefaultMethod() {
        System.out.println("This is a default method in MyInterface");
    }

    void myAbstractMethod();
}

