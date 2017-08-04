package moderjava.edu02.chap02.consumer_ex;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

import static java.lang.System.out;

public class ConsumerExample {

    private static void consumerExample(){

        Consumer<String> consumer = name -> out.println("Hello " + name);
        consumer.accept("n0roo");

        BiConsumer<String, String> bigConsumer = (t, u) -> out.println(t + u);
        bigConsumer.accept("Modern", "Java");

        DoubleConsumer doubleConsumer = d -> out.println(d + 10.0);
        doubleConsumer.accept(10.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> out.println(t + "'s Salary is ₩ " + i + "");
        objIntConsumer.accept("n0roo", 100000000);
    }

    public static void main(String [] args){
        consumerExample();
    }

}
