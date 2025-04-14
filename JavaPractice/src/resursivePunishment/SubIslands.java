package resursivePunishment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1. Read problem, take notes
    // so it's grid 2 that is the sub, expect grid 1 to have the "bigger" islands (but can be same size)
    // diagonal doesn't matter

// 2. come up with rough solutions
    // how would I check one? Assume I have a 1
        // Go through and track the land I've visited. Collecting as I go.
            // put all of those coordinates in a map, mapping what to the coordinates?
    
    // Use a map, value would be the coordinates of land, but what would the key be?

    // Maybe a set instead? A list of sets that contains coordinates of all islands
        // set { {[0,1], [02]}, }
        // create one for both grids
            // go through and check all the islands of grid 2 and see if there's any set that contains all of those in the first set
    
    // globals
        // map1
        // map2

        // islandSet1
        // islandSet2

// 3. talk about them

// 4. psuedocode

// 5. implement!

// 6. optimize

public class SubIslands {
    public int[][] map1;
    public int[][] map2;

    // Sets of sets containing islands, which are coordinates
    // ex { {[1,2], [2,1]}; {[2,5], [6,3]} }
    public Set<Set<List<Integer>>> islandSet1 = new HashSet<>();
    public Set<Set<List<Integer>>> islandSet2 = new HashSet<>();

    public Set<List<Integer>> curIslands = new HashSet<>();
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.map1 = grid1;
        this.map2 = grid2;

        // populate islandSet1
        for (int i = 0; i < grid1.length; i++) {
            for (int pos = 0; pos < grid1[i].length; pos++) {
                // Land ho!
                if (grid1[i][pos] == 1) {
                    mapDiver(this.map1, i, pos);
                    this.islandSet1.add(new HashSet<>(this.curIslands));
                    this.curIslands = new HashSet<>();
                }
            }
        }

        // popuplate islandSet2
        for (int i = 0; i < grid2.length; i++) {
            for (int pos = 0; pos < grid2[i].length; pos++) {
                // Land ho!
                if (grid2[i][pos] == 1) {
                    mapDiver(this.map2, i, pos);
                    this.islandSet2.add(new HashSet<>(this.curIslands));
                    this.curIslands = new HashSet<>();
                }
            }
        }

        System.out.println("set 1: " + this.islandSet1);
        System.out.println("set 2: " + this.islandSet2);

        // go through islandSet2
            // if we found a sub-island(an island that all coordinates exist in islandSet1) increment count

        int subCount = 0;
        // each island in grid 2
        for (Set<List<Integer>> island : this.islandSet2) {
            // if grid 1 has that island and more
            for (Set<List<Integer>> bigIsland : this.islandSet1) {
                if (bigIsland.containsAll(island)) {
                    subCount++;
                }
            }
        }
        
        return subCount;
    }

    /*
     * will be called if we find some land
     * will go through each neighbor, collecting the coordinates and adding them to the curIslands
     */
    private void mapDiver(int[][] map, int array, int index) {
        // if out of bounds return
        if (array < 0 || index < 0 || array >= map.length || index >= map[array].length) {
            return;
        }

        // land ho!
        if (map[array][index] == 1) {
            map[array][index] = -1;
            List<Integer> newIsland = new ArrayList<>();
            newIsland.add(array);
            newIsland.add(index);

            this.curIslands.add(newIsland);
            
            mapDiver(map, array - 1, index);
            mapDiver(map, array + 1, index);
            mapDiver(map, array, index - 1);
            mapDiver(map, array, index + 1);
        }
    }
}
