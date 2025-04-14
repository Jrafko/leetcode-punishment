package warmups;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";

        if (strs.length == 0) {
            return longestPrefix;
        } else if (strs.length == 1) {
            return strs[0];
        }

        // Go through the characters in the first string
        for (int i = 0; i < strs[0].length(); i++) {
            // Check if out of bounds
            for (int str = 0; str < strs.length; str++) {
                if (i >= strs[str].length()) {
                    return longestPrefix;
                }
            }

            char charOn = strs[0].charAt(i);
            longestPrefix += charOn;

            // Check for a violation, if so remove the character then break
            for (int str = 0; str < strs.length; str++) {
                if (strs[str].charAt(i) != charOn) {
                    return longestPrefix.substring(0, i);
                }
            }

        }
        return longestPrefix;
    }
}
