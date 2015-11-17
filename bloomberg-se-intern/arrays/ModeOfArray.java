import java.util.HashMap;
import java.util.Random;

public class ModeOfArray {
    
    public static Object findMode(Object[] arr) {
        HashMap<Object, Integer> freq = new HashMap<Object, Integer>();
        for(Object obj : arr) {
            if(!freq.containsKey(obj)) freq.put(obj, 0);
            else freq.put(obj, freq.get(obj) + 1);
        }

        HashMap.Entry<Object, Integer> max = null;
        for(HashMap.Entry<Object, Integer> cur : freq.entrySet()) {
            if(max == null || cur.getValue().compareTo(max.getValue()) > 0) max = cur;
        }
        return max.getKey();
    }

    public static void main(String[] args) {
        Random rand = new Random();

        Integer[] arr = new Integer[20];
        for(int i = 0; i < 20; i ++) arr[i] = rand.nextInt(5) + 1;
        System.out.print("\n|");
        for(int i : arr) System.out.print(i + "|");

        System.out.println("\nMost frequent value is " + findMode(arr));
    }
}
