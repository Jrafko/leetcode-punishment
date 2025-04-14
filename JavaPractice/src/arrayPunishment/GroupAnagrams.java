package arrayPunishment;

import java.util.*;

// 1. read the problem
    // so there's a bunch of strings, they can be anagrams of each other
    // put them together and return them

// 2. think of some rough solutions
    // Maps?
        // keep track of characters to counts, map that to the words

    // go through the array
        // count the characters in each string, tracking them
        // put them in a list
            // add that list to the map
    
    // return a list of all the lists in the map

// 3. discuss

// 4. psuedocode

// 5. implement

// 6. optimize

public class GroupAnagrams {
    // map of char->count to strings
    public Map<Map<Character,Integer>, List<String>> charCountToStringsMap = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();

        // go through the strings
            // go through each string
            // count the characters in each string, tracking them
                // put them in a list
                    // add that list to the map
        
        for (int stringOn = 0; stringOn < strs.length; stringOn++) {
            String curString = strs[stringOn];

            Map<Character,Integer> charCount = new HashMap<>();

            // Go through the string, keeping track of each character's count
            for (int letter = 0; letter < curString.length(); letter++) {
                char letterOn = curString.charAt(letter);
                charCount.putIfAbsent(letterOn, 0);
                charCount.put(letterOn, charCount.get(letterOn) + 1);
            }

            // Add that to the overall list
            List<String> newList = new LinkedList<>();
            this.charCountToStringsMap.putIfAbsent(charCount, newList);
            this.charCountToStringsMap.get(charCount).add(curString);
        }

        for (List<String> groups : this.charCountToStringsMap.values()) {
            solution.add(groups);
        }

        return solution;
    }
}
