package normal;

/**
 * Minimum Operations to Make a Special Number
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-a-special-number/description/">...</a>
 */
public class MinimumOperationsToMakeASpecialNumber {
    public static int minimumOperations(String num) {
        return recFun(num,0);
    }
    public static int recFun(String num, int ans){
        if(num.isEmpty())
            return ans;
        if(num.length()==1){
            int value = Integer.parseInt(num);
            if(value == 0)
                return ans;
            return ans+1;
        }
        if(num.length()==2){
            int value = Integer.parseInt(num);
            if(value == 25 || value == 50 || value == 75 || value == 0){
                return ans;
            }
            if(value%10==0)
                return ans+1;
            return ans+2;
        }
        int value = Integer.parseInt(num.substring(num.length()-2));
        if(value == 25 || value == 50 || value == 75 || value == 0){
            return ans;
        }
        String newNum = num.substring(0,num.length()-1);
        return recFun(newNum,ans+1);
    }

    public static void main(String[] args) {
        System.out.println( minimumOperations("2908305"));
    }
}
