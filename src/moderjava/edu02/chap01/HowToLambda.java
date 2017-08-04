package moderjava.edu02.chap01;

import java.util.function.Consumer;

import static java.lang.System.out;

public class HowToLambda {

    public static void howToLambdaSyntax(){

        final LambdaExamNoneVariable lambdaExamNoneVariable = () -> out.println("Hello Lambda!");
        lambdaExamNoneVariable.doLambda();

        /* same Syntax
            LambdaExamNoneVariable lambdaExamNoneVariable = () ->{ System.out.println("Hello Lambda!")};
            LambdaExamNoneVariable lambdaExamNoneVariable = () -> System.out.println("Hello Lambda!");
         */

        final LambdaExamVoid<Integer> lambdaExemVoid;
        lambdaExemVoid = a -> out.println("Input Variable Value is " + a.toString());

        /* same Syntax

         lambdaExamVoid = (Integer a) -> {
            System.out.println("Input Variable Value is " + a.toString());
         };

         lambdaExamVoid = (a) -> {
            System.out.println("Input Variable Value is " + a.toString());
         };

         lambdaExamVoid = (a) -> {System.out.println("Input Variable Value is " + a.toString());};
         lambdaExamVoid = (a) -> System.out.println("Input Variable Value is " + a.toString());;

         */

        lambdaExemVoid.doLambda(1);

        //use Default method
        lambdaExemVoid.printType(1);

        //same Functional Interface Another Class
        final LambdaExamVoid<String> lambdaExemVoidStr;
        lambdaExemVoidStr = a -> out.println("Input Variable Value is " + a);

        lambdaExemVoidStr.doLambda("1");
        lambdaExemVoidStr.printType("1");


        final LambdaExamResult<String, Integer> lambdaExamResult = str -> Integer.parseInt(str) + 10;

        /* same Syntax
            lambdaExamResult = (str) -> {return Integer.parseInt(str) + 10;};
            lambdaExamResult = (str) -> Integer.parseInt(str) + 10;
        */

        lambdaExamResult.printResult(lambdaExamResult.doLambda("10"));


    }


    public static void main (String [] args){
        howToLambdaSyntax();
    }



}
