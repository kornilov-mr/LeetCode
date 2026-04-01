package normal;

/**
 * Count Number of Ways to Place Houses
 * <a href="https://leetcode.com/problems/count-number-of-ways-to-place-houses/description/">...</a>
 */
public class CountNumberOfWaysToPlaceHouses {
    public int mod = (int) (Math.pow(10,9)+7);
    public int countHousePlacements(int n) {

        int noHouseLast = 1;
        int houseLast = 1;
        for(int i=1;i<n;i++){
            int temp = houseLast;
            houseLast = noHouseLast;
            noHouseLast= houseLast+temp;
        }
        long oneSide = noHouseLast+houseLast;
        return Math.toIntExact((oneSide * oneSide) % mod);
    }

    public static void main(String[] args) {
        CountNumberOfWaysToPlaceHouses cl = new CountNumberOfWaysToPlaceHouses();
        System.out.println(cl.countHousePlacements(3));
    }
}
