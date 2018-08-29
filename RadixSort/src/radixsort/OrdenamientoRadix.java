package radixsort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author juliana
 */
public class OrdenamientoRadix {
  
    static void sort( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        
        while (m / exp > 0)
        {
            int[] arreglo = new int[10];
            //
            for (i = 0; i < n; i++)
                arreglo[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                arreglo[i] += arreglo[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--arreglo[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }  
}
}