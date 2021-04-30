package Lists;

import Objects.Produkt;

import java.util.NoSuchElementException;

public class ProdukteBaum implements IList<Produkt> {

    Element root;

    class Element{
        Produkt value;
        Element left, right;
        Element(Produkt o, Element le, Element ri)
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
    public boolean add(Produkt produkt) {
        Element e = new Element(produkt, null, null);

        if(root == null){
            root = e;
            return true;
        }

        Element it = root;
        while(it != null)
        {
            if(e.value == it.value)
                return true;
            else if(e.value.getId() < it.value.getId())
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

    public void addMany(Produkt[] produkts)
    {
        for(Produkt produkt : produkts)
            add(produkt);
    }

    @Override
    public int size() {
        if(root == null)
            return 0;

        ProdukteBaum.Element it = root;

        return it.size();
    }

    @Override
    public Produkt remove(Produkt produkt) {
        if (root == null)
            throw new NoSuchElementException();

        if (root.value.equals(produkt))
            return removeRoot();


        Element it = root;
        while (it != null) {
            if (produkt.getId() < it.value.getId()) {
                if (it.left != null && it.left.value.getId() == produkt.getId())
                    return removeElement(it, it.left);
                it = it.left;
            } else {
                if (it.right != null && it.right.value.getId() == produkt.getId())
                    return removeElement(it, it.right);
                it = it.right;
            }
        }

        throw new NoSuchElementException();
    }

    private Produkt removeElement(Element p, Element e) {
        if (e == p.left) {
            p.left = null;  // links abgestiegen
        } else {
            p.right = null;  // sonst: rechts
        }

        // Kinder einfuegen
        addElement(e.left);
        addElement(e.right);

        return e.value;
    }

    private Produkt removeRoot() {
        assert(root != null);

        Element e = root;
        if (e.left == null && root.right == null) {
            // Baum leer
            root = null;
        } else if (e.left == null) {
            // nur ein rechtes Kind -> neuer Baum
            root = e.right;
        } else if (e.right == null) {
            // nur ein linkes Kind -> neuer Baum
            root = e.left;
        } else {
            // eines wird root, anderes einfuegen
            root = e.left;
            addElement(e.right);
        }

        return e.value;
    }

    private boolean addElement(Element e) {
        if (e == null)
            return false;

        if (root == null) {
            root = e;
            return true;
        }

        Element it = root;
        while (it != null) {
            if (e.value.getId() == it.value.getId())
                return false;
            else if (e.value.getId() < it.value.getId()) {
                if (it.left == null) {
                    it.left = e;
                    return true;
                } else
                    it = it.left;
            } else {
                if (it.right == null) {
                    it.right = e;
                    return true;
                } else
                    it = it.right;
            }
        }

        return false;
    }

    @Override
    public boolean contains(Produkt produkt) {
        if(root == null)
            return false;

        ProdukteBaum.Element it = root;
        while(it != null)
        {
            if(produkt == it.value)
                return true;
            else if(produkt.getId() < it.value.getId())
            {
                it = it.left;
            }
            else
                it = it.right;
        }

        return false;
    }
}
