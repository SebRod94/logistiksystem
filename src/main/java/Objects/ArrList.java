package Objects;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrList<E> implements IList<E>{

    Object[] list;

    public ArrList()
    {
        list = new Object[0];
    }

    public ArrList(int length)
    {
        list = new Object[length];
    }

    @Override
    public boolean add(Object o) {
        Object[] newList = Arrays.copyOf(list, list.length + 1);
        newList[newList.length - 1] = o;
        list = newList;
        return true;
    }

    public boolean addMany(Object[] o)
    {
        Object[] newList = Arrays.copyOf(list, list.length + o.length);
        int count = list.length;
        for(Object ob : o)
        {
            newList[count] = ob;
            count++;
        }
        list = newList;
        return true;
    }

    public boolean addMany(ArrList<E> o)
    {
        boolean success = addMany(o.toArray());
        return success;
    }

    public boolean insert(Object o, int index)
    {
        Object[] newList = new Object[list.length + 1];
        for(int i = 0, k = 0; i < list.length; i++)
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
        return list.length;
    }

    @Override
    public boolean remove(Object o) {

        Object[] newList = new Object[list.length - 1];
        for (int i = 0, k = 0; i < list.length; i++)
        {
            if(list[i] != o)
            {
                if(k > newList.length)
                    return false;
                newList[k] = list[i];
                k++;
            }
        }
        list = newList;
        return true;
    }

    public boolean removeByIndex(int i) {

        Object[] neu = new Object [list.length - 1];
        for (int j = 0, k = 0; j < list.length; j++) {
            if (j == i) continue;
            neu[k++] = list[j];
        }
        list = neu;
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

    public Object[] toArray()
    {
        return list;
    }

}
