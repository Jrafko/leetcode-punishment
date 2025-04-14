package MiscPunishment;
import java.util.*;

// 1. Read the problem
    // 

// 2. Think of some solutions
    // two maps
        // id -> value
        // value -> id
    
    // priority queue of available ids
        // added to when something is removed,
        // retrieved from if there's anything in there

// 3. discuss

// 4. Psuedocode

// 5. implement

// 6. optimize

class RandomizedSet {
    private Map<Integer,Integer> valueToId = new HashMap<>();
    private Map<Integer,Integer> idToValue = new HashMap<>();
    private Queue<Integer> avialableIds = new PriorityQueue<>();

    public RandomizedSet() {
        return;
    }
    
    /**
     * 
     * @param val val to be inserted
     * @return true if item wasn't here, false otherwise
     */
    public boolean insert(int val) {
        if (this.valueToId.containsKey(val)) {
            return false;
        } else {
            int id;
            if (this.avialableIds.size() > 0) {
                id = this.avialableIds.poll();
            } else {
                id = this.valueToId.size();
            }

            this.valueToId.put(val, id);
            this.idToValue.put(id, val);
            return false;
        }
    }
    
    /**   
     * @param val removes it if present
     * @return true if present, false otherwise
     */
    public boolean remove(int val) {
        if (this.valueToId.containsKey(val)) {
            int id = valueToId.get(val);
            this.valueToId.remove(val);
            this.idToValue.remove(id);
            return true;
        }

        return false;
    }
    
    /**
     * 
     * @return a random element in the set
     */
    public int getRandom() {
        int randomId = (int)(Math.random() * this.idToValue.size() + 1);
        System.out.println("Random ID: " + randomId);
        System.out.println("idToValue: " + this.idToValue);
        return this.idToValue.get(randomId);
    }
}
