package org.example;

import java.util.ArrayList;

/**
 * equal-sum-grid-partition-1
 * <a href="https://leetcode.com/problems/equal-sum-grid-partition-i/description/?envType=daily-question&envId=2026-03-25">...</a>
 */
public class EqualSumGridPartition1 {
    public static boolean canPartitionGrid(int[][] grid) {
        ArrayList<Long> rowSums = new ArrayList<>();
        ArrayList<Long> colSums = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            Long currSum = 0L;
            for(int j=0; j<grid[0].length; j++){
                currSum += grid[i][j];
            }
            rowSums.add(currSum);
        }
        for(int i=0; i<grid[0].length; i++){
            Long currSum = 0L;
            for(int j=0; j<grid.length; j++){
                currSum += grid[j][i];
            }
            colSums.add(currSum);
        }
        long fullSum = 0;
        for(long sums : rowSums)
            fullSum += sums;
        if(fullSum%2 != 0) {
            return false;
        }
        long halfSum = fullSum/2;

        long currSum = 0;
        for(long sums : colSums){
            currSum += sums;
            if(currSum == halfSum)
                return true;
        }
        currSum = 0;
        for(long sums : rowSums){
            currSum += sums;
            if(currSum == halfSum)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{28443},{33959}};
        System.out.println(canPartitionGrid(grid));
    }

}
