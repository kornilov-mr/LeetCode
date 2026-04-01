package hard;

/**
 * Candy
 * <a href="https://leetcode.com/problems/candy/description/">...</a>
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i=0;i<ratings.length;i++)
            candies[i]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                candies[i]= candies[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
            }
        }
        int sum = 0;
        for(int num : candies){
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy cl = new Candy();
        int[] ratings = new int[]{1,3,2,1,0};
        System.out.println(cl.candy(ratings));
    }
}
