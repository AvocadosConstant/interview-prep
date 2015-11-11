import java.lang.IndexOutOfBoundsException;
import java.lang.StringBuffer;
import java.util.Arrays;

public class DynamicArray {

    private final int DEFAULT_CAP = 10;

    private int size;
    private Object[] arr;

    /** Constructs an empty dynamic array with an initial capacity of 10.
      */
    public DynamicArray() {
        size = 0;
        arr = new Object[DEFAULT_CAP];
    }

    /** Constructs an empty dynamic array with specified initial capacity.
      * 
      * @param initSize initial capacity of dynamic array
      */
    public DynamicArray(int initCap) {
        size = 0;
        arr = new Object[initCap];
    }

    /** Returns number of elements in dynamic array.
      *
      * @return number of elements in dynamic array
      */
    public int size() {return size;}

    /** Returns true if the list contains no elements.
      *
      * @return true if the list contains no elements.
      */
    public boolean isEmpty() {return size == 0;} 

    /** Appends the specified element to the end of the list.
      *
      * @param obj element to be appended to the list
      */
    public void add(Object obj) {
        if(size == arr.length) grow();
        arr[size] = obj;
        size++;
    }

    /** Removes the element at the specified index in the list.
      * Shifts any subsequent elements to the left.
      *
      * @param index index of the element to be removed
      * @return the element that was removed from the list
      * @throws IndexOutOfBoundsException if the index is out of range
      */
    public Object remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Object retObj = arr[index];
        while(index < size) {
            arr[index] = arr[++index];
        }
        size--;
        return retObj;
    }

    /** Returns the element at the specified index in the list.
      *
      * @param index index of the element to return
      * @return the element at the specified position in the list
      */
    public Object get(int index) {
        if(index < size && index >=0) return arr[index];
        throw new IndexOutOfBoundsException();
    }

    /** Increases the capacity of the dynamic array by a factor of 1.5.
      */
    public void grow() {
        arr = Arrays.copyOf(arr, (arr.length * 3)/2);
    }

    /** Returns a string containing the string representations of all elements in the list.
      *
      * @return String representing all elements in the list
      */
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
