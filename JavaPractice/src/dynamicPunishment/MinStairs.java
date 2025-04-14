package dynamicPunishment;

import java.util.HashMap;
import java.util.Map;

public class MinStairs {
    Map<Integer, Integer> stepToCost = new HashMap<>();
    int[] cost;
    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return Math.min(minHelper(cost.length - 2), minHelper(cost.length - 1));
    }

    public int minHelper(int curStep) {
        if (curStep == 0 || curStep == 1) {
            return this.cost[curStep];
        }

        // haven't found the cost min cost to this step before, set it
        if (!this.stepToCost.containsKey(curStep)) {
            int oneBack = minHelper(curStep - 1);
            int twoBack = minHelper(curStep - 2);
            int min = cost[curStep] + Math.min(oneBack, twoBack);
            this.stepToCost.put(curStep, min);
        }

        // return the min cost to this one
        return this.stepToCost.get(curStep);
    }
}
