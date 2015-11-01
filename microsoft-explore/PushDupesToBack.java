import java.util.ArrayList;

public class PushDupesToBack{

    //Given a sorted ascending array of integers, push all duplicates to the back.
    //  [1,2,2,4,5,5] -> [1,2,4,5,2,5]
    //  [1,2,3,3,3] -> [1,2,3,3,3]
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
        for(int i = 0; i < indices.size(); i++) {
            if(!indices.contains(i)) {
                retArr[curIndex] = arr[indices.get(i)];;
                curIndex++;
            }
        }
        return retArr;
    }

    public static void main(String[] args) {
        int[] testArr = {1,2,2,4,5,5};
        int[] retArr = pushDupes(testArr);
        System.out.println("\nOriginal Array");
        for(int i : testArr) System.out.println(i);
        System.out.println("\nReturned Array");
        for(int i : retArr) System.out.println(i);
    }
}
