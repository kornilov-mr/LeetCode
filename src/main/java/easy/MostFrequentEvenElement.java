package easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            if(num%2!=0)
                continue;
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        if(freq.isEmpty())
            return -1;
        int maxValue=-1;
        int maxKey=0;
        for(Map.Entry<Integer,Integer> keyVal: freq.entrySet()){
            if(keyVal.getValue()>maxValue){
                maxKey= keyVal.getKey();
                maxValue = keyVal.getValue();
            }
            if(keyVal.getValue()==maxKey&&maxKey>keyVal.getKey()){
                maxKey= keyVal.getKey();
                maxValue = keyVal.getValue();
            }
        }
        return maxKey;
    }
}
