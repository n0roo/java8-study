package moderjava.edu02.chap01;

public interface LambdaExamVoid<T> {

    void doLambda(T t);

    default void printType(T t){
        System.out.println("Input Variable Type is " + t.getClass().getName());
    }
}
