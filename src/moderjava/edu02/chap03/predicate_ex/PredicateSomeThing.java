package moderjava.edu02.chap03.predicate_ex;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSomeThing {

    public static Predicate<SomeThing> isHello(){
        return p -> p.getSomeStr().contains("Hello");
    }

    public static Predicate<SomeThing> isHundredOverflow(){
        return p -> p.getSomeInt() > 100;
    }

    public static Predicate<SomeThing> isAfterDays(){
        return p -> p.getSomeDateTime().isAfter(LocalDateTime.now());
    }

    public static List<SomeThing> filterSomethings(List<SomeThing> someThings, Predicate<SomeThing> predicate){
        return someThings.stream().filter(predicate).collect(Collectors.toList());
    }
}
