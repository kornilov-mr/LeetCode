package easy;

import java.util.*;

/**
 * Smallest Pair with Different Frequencies
 * <a href="https://leetcode.com/problems/smallest-pair-with-different-frequencies/?envType=problem-list-v2&envId=hash-table">...</a>
 */
public class SmallestPairWithDifferentFrequencies
{
    private static Map<Integer, Integer> freqMap = new HashMap<>();
    public static int[] minDistinctFreqPair(int[] nums) {
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entryList =new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e1.getKey() - e2.getKey());
        for(Map.Entry<Integer, Integer> entry : entryList){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int entrySize = entryList.size();
        for(int i = 0; i < entrySize; i++){
            for(int j = i+1; j < entrySize; j++){
                if(entryList.get(i).getValue()!=entryList.get(j).getValue())
                    return new int[]{entryList.get(i).getKey(), entryList.get(j).getKey()};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {7};
        int[] result = minDistinctFreqPair(nums);
    }
}
