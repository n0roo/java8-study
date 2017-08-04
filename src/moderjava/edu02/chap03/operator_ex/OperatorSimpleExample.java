package moderjava.edu02.chap03.operator_ex;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;
import moderjava.edu02.chap02.tobe_builder_pattern.GenericBuilder;

import java.time.LocalDateTime;
import java.util.function.UnaryOperator;

import static java.lang.System.out;

public class OperatorSimpleExample {

    private static void operatorSimpleExaple(){
        UnaryOperator<SomeThing> operator = (someThing1) ->{
            someThing1.setSomeStr("Good Bye");
            someThing1.setSomeDateTime(LocalDateTime.now());
            someThing1.setSomeInt(999);
            return someThing1;
        };

        out.println(
                operator.apply(GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr,"Hello")
                        .with(SomeThing::setSomeDateTime,LocalDateTime.MIN)
                        .with(SomeThing::setSomeInt,1)
                        .build())
        );
    }

    public static void main(String[]args){
        operatorSimpleExaple();
    }
}
