import java.lang.StringBuffer;

public class BigInt {
    
    // Val is stored as a reversed number. (Most significant digit at the end))
    private String val;

    public BigInt(String val) {
        this.val = new StringBuffer(val).reverse().toString();
    }

    public int length() {return val.length();}

    public int get(int index) {return val.charAt(index) - '0';}
    
    public String substring(int start, int end) {return val.substring(start, end);}

    public static BigInt add(BigInt a, BigInt b) {
        StringBuffer retSB = new StringBuffer();

        int longerLength = (a.length() > b.length()) ? a.length() : b.length();
    
        int carry = 0;
        for(int i = 0; i < longerLength; i++) {
            int sum = 0;
            if(a.length() - i > 0 && b.length() - i > 0) {
                sum = a.get(i) + b.get(i) + carry;
                //System.out.printf("%n%d + %d + %d = %d", a.get(i), b.get(i), carry, sum);
            }
            else {
                sum = (a.length() < b.length()) ? b.get(i) : a.get(i);
                sum += carry;
            }
            retSB.append((sum < 10) ? sum : sum%10);
            carry = (sum < 10) ? 0 : sum/10;
        }
        if(carry > 0) retSB.append(carry);
        return new BigInt(retSB.reverse().toString());
    }
   
    /*
    public BigInt multiply(BigInt a, BigInt b) {
    }
    */

    public String toString() {return new StringBuffer(val).reverse().toString();}

    public static void main(String[] args) {
        BigInt a = new BigInt("456");
        BigInt b = new BigInt("789");
        System.out.printf("%n%s + %s = %s%n", a, b, BigInt.add(a, b));
    }
}
