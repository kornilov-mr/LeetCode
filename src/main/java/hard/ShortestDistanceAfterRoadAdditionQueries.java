package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Shortest Distance After Road Addition Queries II
 * <a href="https://leetcode.com/problems/shortest-distance-after-road-addition-queries-ii/description/">...</a>
 */
public class ShortestDistanceAfterRoadAdditionQueries {
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer,Integer> roads = new HashMap<>();
        for(int i=0;i<n-1;i++)
            roads.put(i,i+1);

        for(int i=0;i<queries.length;i++){
            int[] pair = queries[i];
            int start = pair[0];
            int end = pair[1];
            if(!roads.containsKey(start)||roads.get(start) >= end){
                result[i]= roads.size();
                continue;
            }
            var j = roads.get(start);
            while (j < end) {
                j = roads.remove(j);
            }
            roads.put(start,end);
            result[i]= roads.size();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{2,4},{0,2},{0,4}};
        System.out.println(shortestDistanceAfterQueries(5,queries));
    }
}
