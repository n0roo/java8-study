package moderjava.edu02.chap03.and_or_negate_equal;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;
import moderjava.edu02.chap02.tobe_builder_pattern.GenericBuilder;
import moderjava.edu02.chap03.predicate_ex.PredicateSomeThing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class AndOrNegateIsEqualExample {

    private static void andOrNegateIsEqualExample(){
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

        Predicate<SomeThing> allAcceptFilter = PredicateSomeThing.isHello().and(PredicateSomeThing.isHundredOverflow()).and(PredicateSomeThing.isAfterDays());
        Predicate<SomeThing> helloOrFilter = PredicateSomeThing.isHello().or(PredicateSomeThing.isHundredOverflow());
        Predicate<SomeThing> notHello = PredicateSomeThing.isHello().negate();

        Predicate<SomeThing> someThingEqual1 = Predicate.isEqual(GenericBuilder.of(SomeThing::new)
                .with(SomeThing::setSomeStr, "Hello Guy's")
                .with(SomeThing::setSomeInt, 1000)
                .with(SomeThing::setSomeDateTime, LocalDateTime.MAX)
                .build());

        Predicate<SomeThing> someThingEqual2 = Predicate.isEqual(someThings.get(0));

        out.println(someThings.stream().filter(allAcceptFilter).collect(Collectors.toList()));
        out.println(someThings.stream().filter(helloOrFilter).collect(Collectors.toList()));
        out.println(someThings.stream().filter(notHello).collect(Collectors.toList()));

        out.println(someThings.stream().filter(someThingEqual1).collect(Collectors.toList()));
        out.println(someThings.stream().filter(someThingEqual2).collect(Collectors.toList()));

    }

    public static void main(String [] args){
        andOrNegateIsEqualExample();
    }
}
