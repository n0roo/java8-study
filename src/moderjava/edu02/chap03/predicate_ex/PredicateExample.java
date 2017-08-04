package moderjava.edu02.chap03.predicate_ex;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;
import moderjava.edu02.chap02.tobe_builder_pattern.GenericBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.System.out;

public class PredicateExample {

    private static void predicateExample(){

        Predicate<Object> predicate = obj -> obj instanceof String;

        out.println(predicate.test("Str"));
        out.println(predicate.test(1));

        BiPredicate<String, Map<String, String>> biPredicate = (String key,Map<String, String> map) -> map.containsKey(key);
        Map<String, String> testMap = new HashMap<>();
        testMap.put("key","ok");
        testMap.put("key1","ok");

        out.println(biPredicate.test("key", testMap));
        out.println(biPredicate.test("key1", testMap));
        out.println(biPredicate.test("key2", testMap));

        List<SomeThing> someThings = GenericBuilder.of(ArrayList<SomeThing>::new)
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "n0roo")
                        .with(SomeThing::setSomeInt, 1000)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.now())
                        .build())
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "Hello Lambda")
                        .with(SomeThing::setSomeInt, 100)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.MIN)
                        .build())
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "Hello World")
                        .with(SomeThing::setSomeInt, 1000)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.MAX)
                        .build())
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "Good Bye")
                        .with(SomeThing::setSomeInt, 100)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.MAX)
                        .build())
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "Welcome")
                        .with(SomeThing::setSomeInt, 1000)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.MIN)
                        .build())
                .with(ArrayList::add, GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr, "Hello Guy's")
                        .with(SomeThing::setSomeInt, 1000)
                        .with(SomeThing::setSomeDateTime, LocalDateTime.MAX)
                        .build())
                .build();

        System.out.println(PredicateSomeThing.filterSomethings(someThings, PredicateSomeThing.isHello()));
        System.out.println(PredicateSomeThing.filterSomethings(someThings, PredicateSomeThing.isHundredOverflow()));
        System.out.println(PredicateSomeThing.filterSomethings(someThings, PredicateSomeThing.isAfterDays()));
    }


    public static void main(String [] args){
        predicateExample();
    }
}
