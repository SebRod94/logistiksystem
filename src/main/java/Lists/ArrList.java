package Lists;

import java.util.Arrays;

public class ArrList<E> implements IList<E> {

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

    public boolean insert(Object o, int index)
    {
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
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(E o) {
        for (int i = 0, k = 0; i < list.length; i++)
        {
            if(list[i] == o) continue;
            list[k++] = list[i];
        }
        return true;
    }

    public boolean removeByIndex(int i) {
        for (int j = 0, k = 0; j < list.length; j++) {
            if (j == i) continue;
            list[k++] = list[j];
        }
        return true;
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

    public E[] toArray()
    {
        return (E[])list;
    }

    private void ensureCapacity() {
        int newSize = list.length + 10;
        list = Arrays.copyOf(list, newSize);
    }
}
