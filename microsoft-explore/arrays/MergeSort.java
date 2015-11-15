import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if(arr.length <= 1) return arr;
        return Merge.merge(mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2)), mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length)));
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] inputArr = new int[20];
        for(int i = 0; i < 20; i++) inputArr[i] = rand.nextInt(20) + 1;
        int[] sortedArr = mergeSort(inputArr);
        
        System.out.println("\nInput Array:  " + Arrays.toString(inputArr));
        System.out.println("Sorted Array: "+ Arrays.toString(sortedArr));
    }
}
