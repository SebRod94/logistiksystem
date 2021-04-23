package Lists;

public interface IList<E> {
    boolean add(E e);
    int size();
    boolean remove(E e);
    boolean contains(E e);
}
