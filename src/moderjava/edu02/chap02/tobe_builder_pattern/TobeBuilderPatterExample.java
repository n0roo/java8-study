package moderjava.edu02.chap02.tobe_builder_pattern;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.out;

public class TobeBuilderPatterExample {

    private static void tobeBuilderPatterExample(){
        Supplier<List<Integer>> listSupplier = ArrayList::new;
        Consumer<Integer> printConsumer = out::println;

        List<Integer> integers = listSupplier.get();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);

        integers.forEach(printConsumer);

        SomeThing someThing = GenericBuilder.of(SomeThing::new)
                .with(SomeThing::setSomeStr, "n0roo")
                .with(SomeThing::setSomeInt, 1000)
                .build();

        System.out.println(someThing.toString());
    }

    public static void main(String [] args){
        tobeBuilderPatterExample();
    }
}
