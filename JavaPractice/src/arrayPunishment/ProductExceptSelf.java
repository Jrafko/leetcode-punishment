package arrayPunishment;

import java.util.Arrays;

// 1. read the problem, take notes (2-3min)
    // multiply everything together in the array, except the thing at the index

// 2. come up with some rough ideas (2-3min)
    // what data structures would I need?
    // how would I do this on an array of 2 elements, how about 3?

    // calculate entire thing, then go through again? O(2n) and can't use division
    
    // how would i do in O(n^2)? 
        // go through, keeping track of product so far
            // go through the rest from each number multiplying without the current one
            // add that result to the array
            // add to current product
    // can I make this O(n)?


    // could also copy the array
        // go through and multiply all indecies in the new one except the one we're on
    // closer?

    // 2 passes, get the multiplications of the ones before and the ones after
    // then make the new one with the products of those

// 3. discuss solutions

// 4. psuedocode/outline

// 5. implement (tweaking outline slightly most likely)

// 6. optimize

public class ProductExceptSelf {
    private int[] productArr;
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] post = new int[nums.length];
        this.productArr = new int[nums.length];

        // construct prefix
        int soFar = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = soFar;
            soFar *= nums[i];
        }

        // construct post
        soFar = 1;
        for (int i = nums.length; i > 0; i--) {
            post[i - 1] = soFar;
            soFar *= nums[i - 1];
        }

        // construct product
        for (int i = 0; i < nums.length; i++) {
            this.productArr[i] = prefix[i] * post[i];
        }

        return this.productArr;
    }
}
