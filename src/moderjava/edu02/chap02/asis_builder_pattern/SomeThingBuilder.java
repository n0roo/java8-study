package moderjava.edu02.chap02.asis_builder_pattern;

import java.time.LocalDateTime;

public class SomeThingBuilder {

    private String someStr;
    private Integer someInt;
    private LocalDateTime someDateTime;

    public SomeThingBuilder setSomeStr(String someStr) {
        this.someStr = someStr;
        return this;
    }

    public SomeThingBuilder setSomeInt(Integer someInt) {
        this.someInt = someInt;
        return this;
    }

    public SomeThingBuilder setSomeDateTime(LocalDateTime someDateTime) {
        this.someDateTime = someDateTime;
        return this;
    }

    public SomeThing build(){
        return new SomeThing(someStr, someInt, someDateTime);
    }
}
