package normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Merge Adjacent Equal Elements
 * <a href="https://leetcode.com/problems/merge-adjacent-equal-elements/description/">...</a>
 */
public class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> result = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(result.isEmpty()){
                result.add((long) nums[i]);
                continue;
            }
            if(nums[i] == result.peek()){
                long currResult = nums[i];
                while(!result.isEmpty()&&result.peek()==currResult){
                    currResult+= result.pop();
                }
                result.add(currResult);
            }else{
                result.add((long) nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeAdjacentEqualElements cl = new MergeAdjacentEqualElements();
        cl.mergeAdjacent(new int[]{2,2,4});
    }

}
