package MiscPunishment;

// 1. read problem (2-3min)
    // so substring that's a palindrome

// 2. jot some rough ideas (5min)
    // go through the string
        // check for a palindrome, extending from the index
        // if we break pattern check length
    // return max

    // helper function to get the sub-palindrome at an index

// 3. talk about them

// 4. psuedocode

// 5. implement

// 6. optimize

public class PalindromicPunishment {
    String string;
    String best = "";
    public String longestPalindrome(String s) {
        this.string = s;
        
        for (int c = 0; c < s.length(); c++) {
            String pali = getSubPalindrome(String.valueOf(s.charAt(c)), c);
            if (pali.length() > this.best.length()) {
                this.best = pali;
            }
        }

        return this.best;
    }


    public String getSubPalindrome(String soFar, int index) {
        // first index, check one next to it
        if (index == 0) {
            if (index + 1 < this.string.length() && this.string.charAt(index + 1) == this.string.charAt(index)) {
                return soFar + soFar;
            } else {
                return soFar;
            }
        }

        // at the end, check before it
        if (index == this.string.length() - 1) {
            if (index - 1 >= 0 && this.string.charAt(index - 1) == this.string.charAt(index)) {
                return soFar + soFar;
            } else {
                return soFar;
            }
        }

        int start = index - 1;
        int end = index + 1;
        while (start >= 0 && end < this.string.length()) {
            char startChar = this.string.charAt(start);
            char endChar = this.string.charAt(end);

            if (startChar == endChar) {
                soFar = startChar + soFar + endChar;
                start--;
                end++;
            } else {
                return soFar;
            }
        }
        return soFar;
    }
}
