package hard;

/**
 * Number of Ways to Stay in the Same Place After Some Steps
 * <a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/">...</a>
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        long[] prevLayer = new long[arrLen];
        long[] currLayer = new long[arrLen];
        prevLayer[0] = 1;
        if(arrLen!=1)
            prevLayer[1] = 1;
        currLayer[0] = 1;
        if(arrLen!=1)
            currLayer[1] = 1;
        for (int currStep = 1; currStep < steps; currStep++) {
            if(arrLen==1){
                currLayer[0] = prevLayer[0];
            }else{
                currLayer[0] = (prevLayer[0] + prevLayer[1])%((int)Math.pow(10,9) + 7);
                currLayer[arrLen-1] = (prevLayer[arrLen-1]+prevLayer[arrLen-2])%((int)Math.pow(10,9) + 7);
            }
            for (int i = 1; i < Math.min(currStep + 2,arrLen-1); i++) {
                currLayer[i] = prevLayer[i] + prevLayer[i - 1]+
                            prevLayer[i + 1];
                currLayer[i] %= ((int)Math.pow(10,9) + 7);
            }
            prevLayer = currLayer.clone();
            currLayer = new long[arrLen];
        }
        return Math.toIntExact(prevLayer[0]);
    }

    public static void main(String[] args) {
        var cl = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();
        System.out.println(cl.numWays(3, 1));
    }
}
