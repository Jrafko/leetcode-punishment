package arrayPunishment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 1. read the problem; take notes
    // so need 3 different indicies that add up to 0
        // no repeats

// 2. think of some rough solutions

    // [0, 1, 3, ...] -> [i, j, k, ...]
    // k goes up, then j follows

    // seems like sliding window to me

    // go through the array with 3 pointers
        // if it fits add to collection (if not there)

        // is j less than k? incresae j

        // is i less than j? increase i

        // no? Increase k

    // return collection

// 3. discuss

// 4. psuedocode

// 5. implement

// 6. optimize

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new LinkedList<>();

        int i = 0;
        int j = 1;
        int k = 2;

        while (k < nums.length) {
            // Fits!
            if (i != j && i != k && j != k) { // none are equal to each other
                List<Integer> newSol = new ArrayList<>();
                newSol.add(nums[i]);
                newSol.add(nums[j]);
                newSol.add(nums[k]);
                if (!solutions.contains(newSol)) {
                    solutions.add(newSol);
                } 
            }

            if (j < k) { // is j less than k? incresae j
                j++;
            } else if (i < j) { // is i less than j? increase i
                i++;
            } else { // k needs to go up
                k++;
            }
        }
        return solutions;
    }
}
