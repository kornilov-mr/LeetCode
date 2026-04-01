package normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Number of Burgers with No Waste of Ingredients
 * <a href="https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/description/">...</a>
 */
public class NumberOfBurgersWithNoWasteOfIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices > cheeseSlices * 4)
            return new ArrayList<>();
        if (tomatoSlices < cheeseSlices * 2)
            return new ArrayList<>();
        int tomatoRemain = tomatoSlices-cheeseSlices*2;
        if(tomatoRemain%2!=0)
            return new ArrayList<>();
        int numBig= tomatoRemain /2;
        return new ArrayList<>(List.of(numBig,cheeseSlices-numBig));
    }

    public static void main(String[] args) {
        NumberOfBurgersWithNoWasteOfIngredients cl = new NumberOfBurgersWithNoWasteOfIngredients();
        System.out.println(cl.numOfBurgers(4,17));
    }
}
