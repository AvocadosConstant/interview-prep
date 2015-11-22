import java.lang.StringBuffer;

public class BigInt {
    
    private String val;

    public BigInt(String val) {
        this.val = new StringBuffer(val).toString();
    }

    public BigInt(Integer val) {
        this.val = val.toString();
    }
    
    public String toString() {return new StringBuffer(val).toString();}

    public int length() {return val.length();}

    public int get(int index) {return val.charAt(index) - '0';}

    public static BigInt add(BigInt a, BigInt b) {
        StringBuffer retSB = new StringBuffer();
        StringBuffer aBuff = new StringBuffer(a.toString()).reverse();
        StringBuffer bBuff = new StringBuffer(b.toString()).reverse();

        String longer = (a.length() > b.length()) ? aBuff.toString() : bBuff.toString(); 
        String shorter = (a.length() <= b.length()) ? aBuff.toString() : bBuff.toString(); 
        
        int carry = 0;
        for(int i = 0; i < longer.length(); i++) {
            int sum = 0;
            if(shorter.length() - i  > 0) {
                sum = Character.getNumericValue(shorter.charAt(i)) + Character.getNumericValue(longer.charAt(i)) + carry;
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


    public static void main(String[] args) {
        BigInt a = new BigInt(456);
        BigInt b = new BigInt("789");
        System.out.printf("%n%s + %s%n", a, b);
        System.out.println("Expected answer: " + (456+789));
        System.out.println("BigInt answer:   " + BigInt.add(a, b));
    }
}
