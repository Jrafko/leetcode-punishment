package dynamicPunishment;

import java.util.HashMap;
import java.util.Map;

public class Stairs {
    Map<Integer, Integer> stepToPaths = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } 

        // been here already
        if (!this.stepToPaths.containsKey(n)) {
            this.stepToPaths.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }

        return this.stepToPaths.get(n);
    }
}
