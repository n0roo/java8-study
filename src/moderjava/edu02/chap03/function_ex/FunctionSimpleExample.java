package moderjava.edu02.chap03.function_ex;

import moderjava.edu02.chap02.asis_builder_pattern.SomeThing;
import moderjava.edu02.chap02.tobe_builder_pattern.GenericBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.System.out;

public class FunctionSimpleExample {

    private static void functionSimpleExample(){
        Function<Map<String,Object>,SomeThing> convertor = (m) ->
                GenericBuilder.of(SomeThing::new)
                        .with(SomeThing::setSomeStr,m.containsKey("someStr") ? m.get("someStr").toString() : "")
                        .with(SomeThing::setSomeInt,m.containsKey("someInt") ? Integer.parseInt(m.get("someInt").toString()) : 0)
                        .with(SomeThing::setSomeDateTime,m.containsKey("someDateTime") ? LocalDateTime.parse(m.get("someDateTime").toString()) : null)
                        .build();

        Map<String,Object> example = new HashMap<>();
        example.put("someStr","Hello Functional Interface");
        example.put("someInt",1000);
        example.put("someDateTime",LocalDateTime.now());

        out.println(convertor.apply(example));
    }

    public static void main(String [] args){
        functionSimpleExample();
    }
}
