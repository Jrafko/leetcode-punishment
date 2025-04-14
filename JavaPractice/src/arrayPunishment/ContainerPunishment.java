package arrayPunishment;

// 1. read problem, take notes
    // need to find max amount of water
    // each value is a "height"
    // distance between does not matter?

// 2. come up with some rough solutions
    // O(n^2) is a double loop
        // not ideal, but would work

    // two pointers?
        // right and a left
        // keep track of the max of both, moving them towards each other
        // when we get to the end we can return the min of the two * itself

// 3. discuss

// 4. psuedocode

// 5. implement

// 6. optimize

public class ContainerPunishment {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftHeight = height[left];
        int rightHeight = height[right];
        int maxArea = 0;

        while (left < right) {
            leftHeight = Math.max(leftHeight, height[left]);
            rightHeight = Math.max(rightHeight, height[right]);
            int width = right - left;
            int minHeight = Math.min(leftHeight, rightHeight);
            maxArea = Math.max(maxArea, width * minHeight);

            // if right is larger than left or they're the same left goes right once
            if (rightHeight >= leftHeight) {
                left++;
            } else {
                // if the left is higher than the right make right go left
                right--;
            }
        }
        
        return maxArea;
    }
}
