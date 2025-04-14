package resursivePunishment;

// 1. Read problem, take notes (2-3min)
    // diagonal doesn't count

// 2. Think of some high level solutions (2-3min)
    // how would I do one island?
        // if I have an island, count area of each island
        // track in a global variable
    
    // Recursion
        // go through map, check if I found some land
            // spread from that point, collecting the area of that island
                // if its area is larger than the max, save it
        // reset current counter

        // globals:
            // current counter, since will be used throughout recursion
            // current max, used globally
            // the map, if this problem were expanded it would be wise to have it global

// 3. Discuss options

// 4. Pseudocode

// 5. Implement

// 6. Optimize


public class MaxIsland {
    private int currentCount = 0;
    private int currentMax = 0;
    private int[][] map;

    public int maxAreaOfIsland(int[][] grid) {
        this.map = grid;
        
        for (int i = 0; i < grid.length; i++) {
            for (int pos = 0; pos < grid[i].length; pos++) {
                // Found land!
                if (this.map[i][pos] == 1) {
                    mapDiver(i, pos);
                    // Set to max; reset count
                    this.currentMax = Math.max(this.currentMax, this.currentCount);
                    this.currentCount = 0;
                }
            }
        }

        return this.currentMax;
    }

    /*
     * @purpose will take in an array and a position in the array
     *          will check if it's land, if so mark and continue
     * @param array the array to check
     * @param position the position to check
     * @side-effects uses currentCount
     */
    public void mapDiver(int array, int position) {
        // if we're out of range, return
        if (array < 0 || position < 0 || array >= this.map.length || position >= this.map[array].length) {
            return;
        }

        // Found land!
        if (this.map[array][position] == 1) {
            // set as visited and increase count
            this.map[array][position] = -1;
            this.currentCount++;

            // Recurse
            mapDiver(array - 1, position);
            mapDiver(array + 1, position);
            mapDiver(array, position - 1);
            mapDiver(array, position + 1);
        }
    }
}
