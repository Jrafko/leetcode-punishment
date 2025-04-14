package warmups;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        
        int curNum = n;
        // While n is greater than 3, keep dividing by 3
        while (curNum > 3) {
            if (curNum % 3 != 0) {
                return false;
            }

            curNum = curNum / 3;
        }
        
        // If the result is not 3 or 1 return false
        if (curNum != 3) {
            return false;
        }

        return true;
    }
}
