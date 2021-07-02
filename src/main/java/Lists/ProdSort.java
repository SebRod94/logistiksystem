package Lists;

import Objects.Produkt;

public class ProdSort {

    static void swap(Produkt[] a, int i, int j) {
        Produkt hilf = a[i];
        a[i] = a[j];
        a[j] = hilf;
    }

    public static void ssort(Produkt[] a) {

        for (int i = 0; i < a.length; i++) {

            int p = i;

            for (int j = i + 1; j < a.length; j++)
                if (a[j].getId().compareTo(a[p].getId()) < 0)
                    p = j;

            if (i != p)
                swap(a, i, p);
        }
    }
}
