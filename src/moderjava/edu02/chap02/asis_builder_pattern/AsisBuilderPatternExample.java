package moderjava.edu02.chap02.asis_builder_pattern;

import java.time.LocalDateTime;

public class AsisBuilderPatternExample {

    private static void asisBuilderPatternExample(){
        SomeThing someThing = new SomeThing();
        someThing.setSomeStr("Hello!");
        someThing.setSomeInt(10);
        someThing.setSomeDateTime(LocalDateTime.now());
        System.out.println(someThing.toString());

        SomeThing someThing1 = new SomeThing("Hello", 10, LocalDateTime.now());
        System.out.println(someThing1.toString());

        SomeThing someThingWithBuilder = new SomeThingBuilder()
                .setSomeStr("Hello Guy's~")
                .setSomeInt(10)
                .setSomeDateTime(LocalDateTime.now())
                .build();

        System.out.println(someThingWithBuilder.toString());

        SomeThingBuilder someThingBuilder = new SomeThingBuilder();

        someThingBuilder.setSomeStr("Hello Buddy's~");
        someThingBuilder.setSomeDateTime(LocalDateTime.MIN);

        SomeThing someThingBuilder2 = someThingBuilder.build();

        System.out.println(someThingBuilder2.toString());

    }

    public static void main(String [] arg){
        asisBuilderPatternExample();
    }
}
