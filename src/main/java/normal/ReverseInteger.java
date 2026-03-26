package normal;


/**
 * Reverse Integer
 * <a href="https://leetcode.com/problems/reverse-integer/description/">...</a>
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int result;
        boolean isNegative = x<0;
        String strX = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(strX).reverse();
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return isNegative ? -result: result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
