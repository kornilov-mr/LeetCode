package easy;

/**
 * Divide a String Into Groups of Size K
 * <a href="https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/">...</a>
 */
public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        String fillString = String.valueOf(fill);
        int stringSize = s.length();
        if(stringSize<=k){
            return new String[]{s+fillString.repeat(k-stringSize)};
        }

        int groupSize = (stringSize-1)/k+1;
        String[] result = new String[groupSize];
        for(int i=0; i<groupSize; i++){
            if(i==groupSize-1){
                result[i] = s.substring(i*k) + fillString.repeat((i+1)*k-stringSize);
            }else{
                result[i]= s.substring(i*k,(i+1)*k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        String[] result = new DivideAStringIntoGroupsOfSizeK().divideString(s, k, fill);
        for(String str: result){
            System.out.println(str);
        }
    }
}
