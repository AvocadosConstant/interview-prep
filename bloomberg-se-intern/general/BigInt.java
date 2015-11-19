import java.lang.StringBuffer;

public class BigInt {
    
    // Val is stored as a reversed number. (Most significant digit at the end))
    private String val;

    public BigInt(String val) {
        this.val = new StringBuffer(val).toString();
    }

    public int length() {return val.length();}

    public int get(int index) {return val.charAt(index) - '0';}
    
    public String substring(int start, int end) {return val.substring(start, end);}

    public static BigInt add(BigInt a, BigInt b) {
        StringBuffer retSB = new StringBuffer();

        String longer = (a.length() > b.length()) ? new StringBuffer(a.toString()).reverse().toString() : new StringBuffer(b.toString()).reverse().toString(); 
        String shorter = (a.length() <= b.length()) ? new StringBuffer(a.toString()).reverse().toString() : new StringBuffer(b.toString()).reverse().toString(); 
        
        int carry = 0;
        for(int i = 0; i < longer.length(); i++) {
            int sum = 0;
            if(shorter.length() - i  > 0) {
                sum = Character.getNumericValue(shorter.charAt(i)) + Character.getNumericValue(longer.charAt(i)) + carry;
                // System.out.printf("%n%c + %c + %d = %d%n", shorter.charAt(i), longer.charAt(i), carry, sum);
            }
            else {
                sum = carry + Character.getNumericValue(longer.charAt(i));
            }
            retSB.append((sum < 10) ? sum : sum % 10);
            carry = (sum < 10) ? 0 : sum / 10;
        }
        if(carry > 0) retSB.append(carry);
        return new BigInt(retSB.reverse().toString());
    }
   
    /*
    public BigInt multiply(BigInt a, BigInt b) {
    }
    */

    public String toString() {return new StringBuffer(val).toString();}

    public static void main(String[] args) {
        BigInt a = new BigInt("456");
        BigInt b = new BigInt("789");
        System.out.printf("%n%s + %s = %s%n%n", a, b, BigInt.add(a, b));
    }
}
