package Objects;

import java.util.NoSuchElementException;

public class TreeList implements ListInterface{

    Element root;

    class Element{
        Object value;
        Element left, right;
        Element(Object o, Element le, Element ri)
        {
            value = o;
            left = le;
            right = ri;
        }

        public int size() {

            int s = 1;
            if(left != null)
            {
                s += left.size();
            }
            if(right != null)
            {
                s += right.size();
            }

            return s;
        }
    }

    @Override
    public boolean add(Object o) {
        Element e = new Element(o, null, null);

        if(root == null){
            root = e;
            return true;
        }

        Element it = root;
        while(it != null)
        {
            if(e.value == it.value)
                return true;
            else if(e.value.hashCode() < it.value.hashCode())
            {
                if(it.left == null)
                {
                    it.left = e;
                    return true;
                }
                else
                    it = it.left;
            }
            else
            {
                if(it.right == null)
                {
                    it.right = e;
                    return true;
                }
                else
                    it = it.right;
            }
        }
        return false;
    }

    @Override
    public int size() {
        if(root == null)
            return 0;

        Element it = root;

        return it.size();
    }

    @Override
    public boolean remove(Object o) {
        if (root == null)
            throw new NoSuchElementException();

        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(root == null)
            return false;

        Element it = root;
        while(it != null)
        {
            if(o == it.value)
                return true;
            else if(o.hashCode() < it.value.hashCode())
            {
                it = it.left;
            }
            else
                it = it.right;
        }

        return false;
    }
}
