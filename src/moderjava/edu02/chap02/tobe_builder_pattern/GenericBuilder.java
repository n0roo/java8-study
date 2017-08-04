package moderjava.edu02.chap02.tobe_builder_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericBuilder<T> {

    private final Supplier<T> anyThing;
    private List<Consumer<T>> anyThingElse = new ArrayList<>();

    public GenericBuilder(Supplier<T> anyThing) {
        this.anyThing = anyThing;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> anyThing) {
        return new GenericBuilder<T>(anyThing);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        anyThingElse.add(c);
        return this;
    }

    public T build() {
        T value = anyThing.get();
        anyThingElse.forEach(modifier -> modifier.accept(value));
        anyThingElse.clear();
        return value;
    }

}
