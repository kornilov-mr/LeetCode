package normal;


/**
 * Minimum Swaps to Arrange a Binary Grid
 * <a href="https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/">...</a>
 */
public class MinimumSwapsToArrangeABinaryGrid {

    public static int[] zeroes;

    public static int minSwaps(int[][] grid) {
        int size = grid.length;
        zeroes = new int[grid.length];
        for (int i = 0; i < size; i++) {
            for (int j = size-1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    zeroes[i]++;
                if(grid[i][j] == 1)
                    break;
            }
        }
        int swapCount = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            int requiredZeroes = size - i - 1;
            if(requiredZeroes <= zeroes[i]) {
                continue;
            }
            int swapTraceBack =0;
            for (int j = i + 1; j < grid.length; j++) {
                if (requiredZeroes <= zeroes[j]) {
                    swapCount+=j-i;
                    swapTraceBack = j-i;
                    break;
                }
            }
            if(swapTraceBack == 0)
                return -1;
            for(int j=i+swapTraceBack; j>i; j--){
                int temp = zeroes[j];
                zeroes[j] = zeroes[j-1];
                zeroes[j-1] = temp;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[][] input = {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        System.out.println(minSwaps(input));
    }

}
