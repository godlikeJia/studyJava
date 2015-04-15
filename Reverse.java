
public class Reverse {
    static String reverse(String orig) {
        if (orig == null || orig.length() <= 1) {
            return orig;
        }
        return reverse(orig.substring(1)) + orig.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Hello";

        System.out.println(reverse(str));
    }
}
