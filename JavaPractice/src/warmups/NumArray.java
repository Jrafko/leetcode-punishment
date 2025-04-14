package warmups;

public class NumArray {
    public int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int curSum = 0;
        while (left <= right) {
            curSum += this.nums[left];
            left++;
        }
        return curSum;
    }
}
