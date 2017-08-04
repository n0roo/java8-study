package moderjava.edu02.chap01;

public interface LambdaExamResult<T,R> {

    R doLambda(T t);

    default void printResult(Integer t){
        System.out.println("Result Value is " + t.toString());
    }
}
