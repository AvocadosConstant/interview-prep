import java.lang.StringBuffer;

//Run Length Encoding
//Ex. AAABBBBBBCDDE -> 3A6B1C2D1E 
public class RLE {
    
    public static String encode(String plainText) {
        StringBuffer retSB = new StringBuffer();
        char running = plainText.charAt(0);
        int streak = 1;
        
        for(int i = 1; i < plainText.length(); i++) {
            running = plainText.charAt(i-1);
            if(running == plainText.charAt(i)) {
                streak++;
            }
            else {
                retSB.append(streak);
                retSB.append(running);
                running = plainText.charAt(i);
                streak = 1;
            }
        }
        retSB.append(streak);
        retSB.append(running);
        return retSB.toString();
    }

    public static String decode(String encodedText) {
        StringBuffer retSB = new StringBuffer();
        int times;
        char cur;
        for(int i = 0; i < encodedText.length()/2; i++) {
            times = encodedText.charAt(2*i) - '0';
            cur = encodedText.charAt(2*i + 1);
            for(int j = 0; j < times; j++) retSB.append(cur);
        }
        return retSB.toString();
    }

    public static void main(String[] args) {
        String plainText = "AAABBBBBBCDDE";
        String encoded = RLE.encode(plainText);
        String decoded = RLE.decode(encoded);
        System.out.printf("%n%s encoded: %s", plainText, encoded);
        System.out.printf("%n%s decoded: %s%n", encoded, decoded);
        System.out.println("\nThey are the same? " + (0 == plainText.compareTo(decoded)));
    }
}
