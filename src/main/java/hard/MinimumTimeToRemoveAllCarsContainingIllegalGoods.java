package hard;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Time to Remove All Cars Containing Illegal Goods
 * <a href="https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/description/">...</a>
 */
public class MinimumTimeToRemoveAllCarsContainingIllegalGoods {
    private static final Map<Integer, Integer> countStepForward = new HashMap<>();
    private static final Map<Integer, Integer> countStepBackward = new HashMap<>();

    public static int minimumTime(String s) {
        for(int i=0; i<s.length()+1; i++){
            countStepForward.put(i, 0);
            countStepBackward.put(i, 0);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countStepForward.put(i+1, Math.min(countStepForward.get(i) + 2, i + 1));
            }
            if (s.charAt(i) == '0'){
                countStepForward.put(i+1, countStepForward.get(i));
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                countStepBackward.put(i, Math.min(countStepBackward.get(i+1) + 2, s.length() - i));
            }
            if (s.charAt(i) == '0'){
                countStepBackward.put(i, countStepBackward.get(i+1));
            }
        }
        int min=0;
        for(int i=0; i<s.length(); i++){
            if(i==0)
                min = countStepForward.get(i) + countStepBackward.get(i);
            min = Math.min(min, countStepForward.get(i) + countStepBackward.get(i));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime("011001111111101001010000001010011"));
    }
}
