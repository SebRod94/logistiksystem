package Lists;

import java.util.Objects;
import java.util.function.Consumer;

public interface Iterator<T> {
    boolean hasNext();
    T next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
