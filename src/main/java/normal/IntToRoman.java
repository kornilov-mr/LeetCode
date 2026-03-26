package normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer to Roman
 * <a href="https://leetcode.com/problems/integer-to-roman/description/?envType=problem-list-v2&envId=hash-table&">...</a>
 */
public class IntToRoman {
    public static final Map<Integer, String> romanMap = new HashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};
    public static String intToRoman(int num) {
        if (num >= 1000){
            int mCount = num/1000;
            return romanMap.get(1000).repeat(mCount) + intToRoman(num%1000);
        }
        if(num >= 900){
            return romanMap.get(900) + intToRoman(num%900);
        }
        if(num >= 500){
            return romanMap.get(500) + intToRoman(num%500);
        }
        if(num >= 400){
            return romanMap.get(400) + intToRoman(num%400);
        }
        if(num >= 100){
            int cCount = num/100;
            return romanMap.get(100).repeat(cCount) + intToRoman(num%100);
        }
        if(num >= 90){
            return romanMap.get(90) + intToRoman(num%90);
        }
        if(num >= 50){
            return romanMap.get(50) + intToRoman(num%50);
        }
        if(num >= 40){
            return romanMap.get(40) + intToRoman(num%40);
        }
        if(num >= 10){
            int xCount = num/10;
            return romanMap.get(1000).repeat(xCount) + intToRoman(num%10);
        }
        if(num == 9){
            return romanMap.get(9);
        }
        if(num >= 5){
            return romanMap.get(5) + intToRoman(num%5);
        }
        if(num == 4){
            return romanMap.get(4);
        }
        return romanMap.get(1).repeat(num) ;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
