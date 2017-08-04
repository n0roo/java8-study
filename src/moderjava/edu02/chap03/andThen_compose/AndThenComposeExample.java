package moderjava.edu02.chap03.andThen_compose;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;
import moderjava.edu02.chap02.tobe_builder_pattern.GenericBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.System.out;

public class AndThenComposeExample {

    private static void andThenComposeExample(){
        Function<Map<String,Object>,SomeThing> convertorMapToSomeThing = (m) ->
                GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr,m.containsKey("someStr") ? m.get("someStr").toString() : "")
                        .with(SomeThing::setSomeInt,m.containsKey("someInt") ? Integer.parseInt(m.get("someInt").toString()) : 0)
                        .with(SomeThing::setSomeDateTime,m.containsKey("someDateTime") ? LocalDateTime.parse(m.get("someDateTime").toString()) : null)
                        .build();
        Function<SomeThing,String> convertorSomethingToStr = SomeThing::toString;

        Function<Map<String,Object>,String> convertorMapToSomeThingStr1 = convertorMapToSomeThing.andThen(convertorSomethingToStr);
        Function<Map<String,Object>,String> convertorMapToSomeThingStr2 = convertorSomethingToStr.compose(convertorMapToSomeThing);

        Map<String,Object> example = new HashMap<>();
        example.put("someStr","Hello Functional Interface");
        example.put("someInt",1000);
        example.put("someDateTime",LocalDateTime.now());

        out.println(convertorMapToSomeThingStr1.apply(example));
        out.println(convertorMapToSomeThingStr2.apply(example));

    }

    public static void main(String [] args){
        andThenComposeExample();
    }
}
