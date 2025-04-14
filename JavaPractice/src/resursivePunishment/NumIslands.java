package resursivePunishment;
// 1. Read problem, take notes (2-3 min)
    // Diagonally doesn't count, important
    // So need to check for an island then repeat for all islands

// 2. Come up with some ideas for solutions (2-3min)

    // recursion?
        // have a 1, check left, right, up, down for a "1", that would mean same island
            // mark the visited parts of land as 0, keep going
            // add one to count
        
        // GOOD OPTION
        // function to "dive" into the neighbors and mark them
            // continue afterwards

// 3. Discuss options (5min)

// 4. Psuedo code

// 5. Implement

// 6. Optimize

public class NumIslands {
    // Global variables since we're using it all over
    private char[][] map;
    private int maxX;
    private int maxY;

    public int numIslands(char[][] grid) {
        if (grid.equals(null)) {
            return 0;
        }

        this.map = grid;
        this.maxX = grid.length;
        this.maxY = grid[0].length;

        int islandCount = 0;
        // each array
        for (int i = 0; i < this.map.length; i++) {
            // each index
            for (int pos = 0; pos < this.map[i].length; pos++) {
                if (this.map[i][pos] == '1') {
                    islandCount++;
                    landDiver(i, pos);
                }
            }
        }

        return islandCount;
    }

    /*
     * @purpose will take in an x and y and traverse from there, marking each as a "-1" (counted)
     * @param arr the array to go to
     * @param index the index coordinate (index in array)
     */
    public void landDiver(int arr, int index) {
        // Check if the index is out of range, if so just return
        if (arr < 0 || index < 0 || arr >= maxX || index >= maxY) {
            return;
        }

        // land ho
        if (this.map[arr][index] == '1') {
            this.map[arr][index] = '2';
            landDiver(arr - 1, index); // Go "up"
            landDiver(arr, index - 1); // go "left"
            landDiver(arr + 1, index); // go "down"
            landDiver(arr, index + 1); // go "right"
        }

        // wasn't land
        return;
    }
}
