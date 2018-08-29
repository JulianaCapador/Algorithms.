package radixsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import static radixsort.OrdenamientoRadix.sort;
/**
 *
 * @author juliana
 */
public class RadixSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      
       Scanner scan = new Scanner( System.in );        
        System.out.println("Radix Sort Testn");
        
        int n, i;
        System.out.println("Ingrese la cantidad de números a ingresar");
        
        n = scan.nextInt();
        int arr[] = new int[ n ];
        
        System.out.println("\nIngrese el "+ n +" número");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        
        sort(arr);
        
        System.out.println("\nLos números ordenados ascendentemente");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        
        System.out.println();                     
    }    
    
}
