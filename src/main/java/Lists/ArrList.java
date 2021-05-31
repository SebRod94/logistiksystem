package Lists;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrList<E> implements IList<E>, Iterable<E> {

    private int size = 0;
    private Object[] list;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrList()
    {
        list = new Object[DEFAULT_CAPACITY];
    }

    public ArrList(int length)
    {
        list = new Object[length];
    }

    class MyIterator implements Iterator<E> {
        int pos = 0;
        public boolean hasNext() {
            return pos < list.length;
        }

        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E h = (E)list[pos];
            pos++;
            return h;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }


    @Override
    public boolean add(E o) {
        if (size == list.length) {
            ensureCapacity();
        }
        list[size++] = o;
        return true;
    }

    public boolean addMany(E[] o)
    {
        for(Object ob : o)
        {
            if (size == list.length) {
                ensureCapacity();
            }
            list[size++] = ob;
        }
        return true;
    }

    public boolean addMany(ArrList<E> o)
    {
        boolean success = addMany(o.toArray());
        return success;
    }

    public void insert(Object o, int index)
    {
        if(index > size)
            throw new ArrayIndexOutOfBoundsException();
        if (size == list.length) {
            ensureCapacity();
        }
        Object[] newList = new Object[list.length];
        for(int i = 0, k = 0; i < size; i++)
        {
            if(i == index)
            {
                newList[k] = o;
                k++;
            }
            newList[k] = list[i];
            k++;
        }
        list = newList;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(E o) {
        Object removedElement = null;
        for (int i = 0, k = 0; i < list.length; i++)
        {
            if(list[i] == o) {
                removedElement = list[i];
                continue;
            }
            list[k++] = list[i];
        }
        return (E)removedElement;
    }

    public E removeByIndex(int i) {
        Object removedElement = null;
        for (int j = 0, k = 0; j < list.length; j++) {
            if (j == i) {
                removedElement = list[i];
                continue;
            }
            list[k++] = list[j];
        }
        return (E)removedElement;
    }

    @Override
    public boolean contains(Object o) {
        for (Object ob : list)
        {
            if(ob == o)
                return true;
        }
        return false;
    }

    public E get(int index)
    {
        return (E)list[index];
    }

    public E[] toArray()
    {
        return (E[])list;
    }

    private void ensureCapacity() {
        int newSize = list.length + 10;
        list = Arrays.copyOf(list, newSize);
    }
}
