package MiscPunishment;

import java.util.*;

// 1. read the problem
    // so we need to return the k closest distances to the origin

// 2. come up with some rough solutions
    // keep track of closest distances and their coordinates
    // thinking priority queue containing distances
    // also have map mapping distance to coordinates

    // at the end return an array of those 

// 3. discuss

// 4. pseudocode

// 5. implement

public class PointsOfPunishment {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Double> closestDistances = new PriorityQueue<>(Collections.reverseOrder());
        Map<Double,int[]> distanceToPoint = new HashMap<>();

        // Go through each point
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            // Calculate the distance, this is wrong
            double distance = x * x + y * y;
            distanceToPoint.put(distance, points[i]);
            closestDistances.add(distance);

            if (closestDistances.size() > k) {
                closestDistances.poll();
            }
        }

        // This is fine
        int[][] kthClosest = new int[k][];
        int i = 0;
        while (closestDistances.size() > 0) {
            kthClosest[i] = distanceToPoint.get(closestDistances.poll());
            i++;
        }

        return kthClosest;
    }
}
