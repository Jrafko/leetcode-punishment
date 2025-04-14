package arrayPunishment;

// 1. Read the problem; take notes
    // sorted in non-decreasing, meaning ascending
    // return the indicies + 1 that add up to the target
        // would be if 0 and 5 were it return [1,6]
    
    // need constant space

// 2. come up with some rough solutions
    // solution with map, which is O(n) memory sadly
        // have a map
        // go through the array, tracking the numbers found
            // at each check if the number has been found, if so return
    
    // O(n^2) solution
        // go through the array
            // go again looking for things that add up to the target
                // if found return

    // creative to optimize
        // have a tracking max, if the last element plus the element we're on is smaller than the target skip the current iteration.

// 3. discuss

// 4. psuedocode

// 5. implement

// 6. optimize

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        
        /* 
        int max = numbers[numbers.length - 1];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] + max < target) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] indicies = {i+1, j+1};
                    return indicies;
                }
            }
        }
        */

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int product = numbers[left] + numbers[right];
            if (product == target) {
                int[] toReturn = {left + 1, right + 1};
                return toReturn;
            }

            // need bigger number
            if (product < target) {
                left++;
            } else {
                // smaller number
                right--;
            }

        }

        return new int[0];
    }
}
