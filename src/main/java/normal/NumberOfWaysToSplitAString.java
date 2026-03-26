package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfWaysToSplitAString {
    public static Map<Long, Long> countMap = new HashMap<>();
    public static int numWays(String s) {
        List<Long> prefixSumList = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(i==0){
                prefixSumList.add(s.charAt(i) == '1' ? 1L : 0L);
            }else{
                prefixSumList.add(prefixSumList.get(i-1) + (s.charAt(i) == '1' ? 1L : 0L));
            }
        }
        Long maxCount = prefixSumList.get(prefixSumList.size()-1);
        if (maxCount %3!=0)
            return 0;

        for(Long sum : prefixSumList){
            countMap.put(sum, (countMap.getOrDefault(sum, 0L) + 1)%1000000007);
        }
        Long inOneCellCount = maxCount/3;
        if(inOneCellCount == 0){
            double n = s.length()-2;
            return (int) (((n+1)/2*n) % 1000000007);
        }
        long ways = ((long) countMap.get(inOneCellCount) *countMap.get(inOneCellCount*2))%1000000007;
        return (int) ways;
    }

    public static void main(String[] args) {
        System.out.println(numWays("0000"));
    }
}
