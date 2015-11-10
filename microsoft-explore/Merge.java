import java.util.Scanner;
import java.util.Arrays;

public class Merge {
 
    /** Merges two sorted arrays
      *
      * @param arrA a sorted int array
      * @param arrB a sorted int array
      * @return merged int array
      */
    public static int[] merge(int[] arrA, int[] arrB) {
        int[] retArr = new int[arrA.length + arrB.length];
        int a = 0, b = 0, r = -1;
        while(r < retArr.length - 1) {
            retArr[++r] = (b > arrB.length - 1 || (a < arrA.length && arrA[a] < arrB[b])) ? arrA[a++] : arrB[b++];
        }
        return retArr;
    }
    
    /** Merges two sorted arrays
      *
      * @param arrA a sorted Comparable array
      * @param arrB a sorted Comparable array
      * @return merged Comparable array
      */
    public static Comparable[] merge(Comparable[] arrA, Comparable[] arrB) {
        int[] retArr = new int[arrA.length + arrB.length];
        int a = 0, b = 0, r = -1;
        while(r < retArr.length - 1) {
            retArr[++r] = (b > arrB.length - 1 || (a < arrA.length && arrA[a] < arrB[b])) ? arrA[a++] : arrB[b++];
        }
        return retArr;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nWhat is the size of your first array: ");
        int[] arrA = new int[in.nextInt()];
        for(int i = 0; i < arrA.length; i++) {
            System.out.printf("    Element %d: ", i);
            arrA[i] = in.nextInt();
        }

        System.out.print("\nWhat is the size of your second array: ");
        int[] arrB = new int[in.nextInt()];
        for(int i = 0; i < arrB.length; i++) {
            System.out.printf("    Element %d: ", i);
            arrB[i] = in.nextInt();
        }

        int[] retArr = merge(arrA, arrB);
        
        System.out.println("\nFirst Array:  " + Arrays.toString(arrA));
        System.out.println("Second Array: " + Arrays.toString(arrB));
        System.out.println("Merged Array: "+ Arrays.toString(retArr));
    }
}
