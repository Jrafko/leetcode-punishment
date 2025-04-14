package arrayPunishment;

// 1. read the problem (2-3min)
    // classic binary search

// 2. jot some rough solutions/ideas
    // have a front and back pointer
    // while the front is less than the back
        // check the middle
        // if found it great
        // if the number is greater than the target move the front here
        // if not set the end here

// 3. talk about them

// 4. psuedocode

// 5. implement

// 6. optimize

// example: [-1,0,3,5,9,12] (len 6), target 9
public class BinarySearch {
    public int search(int[] nums, int target) {
        int front = 0;
        int back = nums.length - 1;
    
        while (front <= back) {
            int curCheck = front + (back - front) / 2;
    
            if (nums[curCheck] == target) {
                return curCheck;
            }
    
            if (nums[curCheck] < target) {
                front = curCheck + 1;
            } else {
                back = curCheck - 1;
            }
        }
    
        return -1; // not found
    }
    
}
