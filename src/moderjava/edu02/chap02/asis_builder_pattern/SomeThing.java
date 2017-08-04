package moderjava.edu02.chap02.asis_builder_pattern;

import java.time.LocalDateTime;

public class SomeThing {

    private String someStr;
    private Integer someInt;
    private LocalDateTime someDateTime;

    //default method
    public SomeThing(){}

    public SomeThing(String someStr, Integer someInt, LocalDateTime someDateTime){
        this.someStr = someStr;
        this.someInt = someInt;
        this.someDateTime = someDateTime;
    }

    public String getSomeStr() {
        return someStr;
    }

    public void setSomeStr(String someStr) {
        this.someStr = someStr;
    }

    public Integer getSomeInt() {
        return someInt;
    }

    public void setSomeInt(Integer someInt) {
        this.someInt = someInt;
    }

    public LocalDateTime getSomeDateTime() {
        return someDateTime;
    }

    public void setSomeDateTime(LocalDateTime someDateTime) {
        this.someDateTime = someDateTime;
    }

    @Override
    public String toString() {
        return "SomeThing{" +
                "someStr='" + someStr + '\'' +
                ", someInt=" + someInt +
                ", someDateTime=" + someDateTime +
                '}';
    }
}
