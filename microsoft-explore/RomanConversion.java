import java.util.HashMap;
import java.util.Scanner;

public class RomanConversion {

    public static final HashMap <Character,Integer> vals;
    static {
        vals = new HashMap<Character, Integer>();
        vals.put( 'I', 1);
        vals.put( 'V', 5);
        vals.put( 'X', 10);
        vals.put( 'L', 50);
        vals.put( 'C', 100);
        vals.put( 'D', 500);
        vals.put( 'M', 1000);
    }
   
    /** Converts a roman numeral string to a decimal integer.
      * Uses a HashMap.
      *
      * @param roman String roman numeral
      * @return integer form of roman numeral
      */
    public static int romanToDecMap(String roman) {
        int retInt = 0;
        int prev = 0;
        for(int i = roman.length() - 1; i >= 0; i--) {
            int cur = vals.get(roman.charAt(i));
            if(cur < prev) retInt-=cur;
            else retInt+=cur;
            prev = cur;
        }
        return retInt;
    }

    /** Converts a roman numeral string to a decimal integer.
      * Recursive method.
      *
      * @param roman String roman numeral
      * @return integer form of roman numeral
      */
    public static int romanToDecimal(String roman) {
        if(roman.length()==0) return 0; //base case

        if(roman.startsWith("M")) return 1000 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("CM")) return 900 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("D")) return 500 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("CD")) return 400 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("C")) return 100 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("XC")) return 90 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("L")) return 50 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("XL")) return 40 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("X")) return 10 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("IX")) return 9 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("V")) return 5 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("IV")) return 4 + romanToDecimal(roman.substring(2));
        if(roman.startsWith("V")) return 5 + romanToDecimal(roman.substring(1));
        if(roman.startsWith("I")) return 1 + romanToDecimal(roman.substring(1));
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        while(true) {
            System.out.print("\nEnter a Roman Number: ");
            String roman = in.next();
            if(roman.toLowerCase().startsWith("q")) break;
            System.out.printf("romanToDecMap: %d%n", romanToDecMap(roman));
            System.out.printf("romanToDecimal: %d%n", romanToDecimal(roman));
        }   
    }
}
