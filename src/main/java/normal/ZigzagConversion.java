package normal;


/**
 * Zigzag Conversion
 * <a href="https://leetcode.com/problems/zigzag-conversion/description/">...</a>
 */
public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int frequency = 2 * numRows - 2;
        for (int currRow = 0; currRow < numRows; currRow++) {
            int currFrequencyIndex = currRow;
            int inBetweenIndex = 0;
            if (!(currRow == 0 || currRow == numRows - 1))
                inBetweenIndex = 2* (numRows - currRow) - 2;
            while(currFrequencyIndex < s.length()){
                sb.append(s.charAt(currFrequencyIndex));
                if(inBetweenIndex != 0)
                    if(currFrequencyIndex+inBetweenIndex< s.length())
                        sb.append(s.charAt(currFrequencyIndex+inBetweenIndex));

                currFrequencyIndex+=frequency;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
