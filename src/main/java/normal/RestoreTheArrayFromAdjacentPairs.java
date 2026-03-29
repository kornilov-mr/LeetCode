package normal;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Restore the Array From Adjacent Pairs
 * <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/">...</a>
 */
public class RestoreTheArrayFromAdjacentPairs {
    public static Map<Integer, ArrayList<Integer>> connections = new HashMap<>();

    public static int[] restoreArray(int[][] adjacentPairs) {
        for (int pairIndex = 0; pairIndex < adjacentPairs.length; pairIndex++) {
            int[] pair = adjacentPairs[pairIndex];
            if (!connections.containsKey(pair[0]))
                connections.put(pair[0], new ArrayList<>());
            if (!connections.containsKey(pair[1]))
                connections.put(pair[1], new ArrayList<>());
            connections.get(pair[0]).add(pairIndex);
            connections.get(pair[1]).add(pairIndex);
        }
        int startNumber = Integer.MIN_VALUE;
        int endNumber = Integer.MIN_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> numberAndCount : connections.entrySet()) {
            if (numberAndCount.getValue().size() == 1) {
                if (startNumber == Integer.MIN_VALUE) {
                    startNumber = numberAndCount.getKey();
                } else {
                    endNumber = numberAndCount.getKey();
                    break;
                }
            }
        }
        boolean[] visitedPairs = new boolean[adjacentPairs.length + 1];
        ArrayList<Integer> result = new ArrayList<>();
        int currentNumber = startNumber;
        while (currentNumber != endNumber) {
            result.add(currentNumber);
            ArrayList<Integer> pairsIndex = connections.get(currentNumber);
            for (int pairIndex : pairsIndex) {
                if (visitedPairs[pairIndex])
                    continue;
                visitedPairs[pairIndex] = true;
                int[] pair = adjacentPairs[pairIndex];
                for (int number : pair) {
                    if (number != currentNumber) {
                        currentNumber = number;
                        break;
                    }
                }
            }
        }
        result.add(endNumber);
        int[] resultArray = new int[result.size()];
        for(int i =0; i < result.size();i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1000,-1000}};
        System.out.println(restoreArray(pairs));
    }
}
