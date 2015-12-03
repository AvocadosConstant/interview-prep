public class Chapter1 {

    //  1.8
    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2.subSequence(0, s2.length()));
    }

    public static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        String doubled = s1 + s1;
        return isSubstring(doubled, s2);
    }
    
    public static void main(String[] args) {
        /*  1.8
            Assume you have a method isSubstring which checks if one word is a substring of
            another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
            only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
        */
        String[] strings = {"waterbottle", "erbottlewat", "erbottlewaX", "INCORRECT"};
        System.out.println("\n1.8");
        for(int i = 0; i < strings.length; i++) {
            System.out.printf("    %s and %s are ", strings[0], strings[i]);
            if(!isRotation(strings[0], strings[i])) System.out.print("not ");
            System.out.printf("rotations of each other.%n");
        }
    }
}
