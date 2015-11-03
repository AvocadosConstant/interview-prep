import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class PushDupesToBack{

    /** Given a sorted ascending array of integers, push all duplicates to the back.
      * Examples
      * [1,2,2,4,5,5] -> [1,2,4,5,2,5]
      * [1,2,3,3,3] -> [1,2,3,3,3]
      * [1,2,2,2,3] -> [1,2,3,2,2]
      * @param Sorted integer array
      * @return Array with duplicates pushed to the back
      */
    public static int[] pushDupes(int[] arr) {
        if(arr.length <= 2) return arr;

        //find indices of dupes
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) indices.add(i);
        }
        if(indices.size() == 0) return arr;

        //fill output array
        int[] retArr = new int[arr.length];
        int curIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!indices.contains(i)) {
                retArr[curIndex] = arr[i];
                curIndex++;
            }
        }
        for(int i : indices) {
            retArr[curIndex] = arr[i];;
            curIndex++;
        }
        return retArr;
    }

    /** Given a sorted ascending array of integers, push all duplicates to the back.
      * Algorithm is in place.
      *
      * Examples
      * [1,2,2,4,5,5] -> [1,2,4,5,2,5]
      * [1,2,3,3,3] -> [1,2,3,3,3]
      * [1,2,2,2,3] -> [1,2,3,2,2]
      * @param Sorted integer array
      * @return Array with duplicates pushed to the back
      */
    public static int[] pushDupesInPlace(int[] arr) {
        if(arr.length <= 2) return arr;

        for(int i = 0; (i < arr.length - 2) && ((i == 0) || (arr[i-1] <= arr[i])); i++) {
            //find length of duplicate sequence
            int dupeLen = 0;
            for(int j = i+1; (j < arr.length) && (arr[j] == arr[i]); j++) {
                dupeLen++;
            }
            //System.out.printf("\nindex = %d | arr[i] = %d | dupeLen = %d\n", i, arr[i], dupeLen);
            if(dupeLen > 0) {
                for(int j = i+1; j < arr.length - dupeLen; j++) {
                    arr[j] = arr[j+dupeLen];
                    //System.out.println(Arrays.toString(arr));
                }
                for(int j = arr.length - dupeLen; j < arr.length; j++) {
                    arr[j] = arr[i];
                    //System.out.println(Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nWhat is the size of your array: ");
        int arrSize = in.nextInt();
        int[] inputArr = new int[arrSize];
        for(int i = 0; i < arrSize; i++) {
            System.out.printf("    Element %d: ", i);
            inputArr[i] = in.nextInt();
        }
        int[] retArr = pushDupes(inputArr);
        System.out.print("\nOriginal Array:        " + Arrays.toString(inputArr));
        System.out.print("\nPushed Array low time: " + Arrays.toString(pushDupes(inputArr)));
        System.out.print("\nPushed Array in place: " + Arrays.toString(pushDupesInPlace(inputArr)));
        System.out.println("\n");
    }
}
