package dynamicPunishment;

// 1. read problem, take notes (2-3min)
    // return min moves to make something valid (min insertions)


// 2. come up with some rough ideas
    // go through, tracking debt
        // if we find a close and have opening debt reduce opening debt
        // if close and no opening debt increase close debt

    // return debt of both

// 3. talk about them

// 4. pseudocode

// 5. implement

// 6. optimize
public class ParenthesisDebt {
    public int minAddToMakeValid(String s) {
        int openDebt = 0;
        int closeDebt = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // Found an opener
            if (curChar == '(') {
                openDebt++;
            } else {
                // closer, but have debt
                if (openDebt > 0) {
                    openDebt--;
                } else {
                    // closer but no debt
                    closeDebt++;
                }
            }
        }

        return openDebt + closeDebt;
    }
}
