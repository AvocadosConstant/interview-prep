import java.lang.IndexOutOfBoundsException;
import java.lang.StringBuffer;
import java.util.Arrays;

public class DynamicArray {

    private final int DEFAULT_SIZE = 10;

    private int size;
    private Object[] arr;

    public DynamicArray() {
        size = 0;
        arr = new Object[DEFAULT_SIZE];
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;} 

    public void add(Object o) {
        if(size == arr.length) grow();
        arr[size] = o;
        size++;
    }

    public Object remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Object retObj = arr[index];
        while(index < size) {
            arr[index] = arr[++index];
        }
        size--;
        return retObj;
    }

    public Object get(int index) {
        if(index < size && index >=0) return arr[index];
        throw new IndexOutOfBoundsException();
    }

    public void grow() {
        arr = Arrays.copyOf(arr, (arr.length * 3)/2);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("{");        
        for(int i = 0; i < size; i++) {
            sb.append(arr[i] + ", ");
        }
        sb.insert(sb.length() - 2, "}");
        return sb.substring(0, sb.length() - 2);
    }
    
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        System.out.println(arr.isEmpty());
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);
        System.out.println(arr.get(0));
        System.out.println(arr.remove(2));
        System.out.println(arr);
        System.out.println("size is " + arr.size());
        System.out.println(arr.isEmpty());
        System.out.println(arr.get(123));
    }
}
