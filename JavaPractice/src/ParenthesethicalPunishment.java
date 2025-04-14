// 1. Read problem, take notes (2-3min)
    // basically need to keep track of most recent opener, if there's a closer that isn't most recent return false

// 2. jote some rough solutions
    // have a stack
    // go through the string
        // if an opener add
        // if a closer test
            // if not valid return false
            // pop from the stack

// 3. talk about them

// 4. psuedocode

// 5. implement

// 6. optimize

import java.util.LinkedList;
import java.util.List;

public class ParenthesethicalPunishment {
    // LL because faster to add and remove
    List<Character> openers = new LinkedList<>();

    public boolean isValid(String s) {
        // go through string
        for (int i = 0; i < s.length(); i++) {
            char charOn = s.charAt(i);
            // if opener add
            if (charOn == '{' || charOn == '[' || charOn == '(') {
                this.openers.add(charOn);
            } else {

                if ((charOn == '}' || charOn == ')' || charOn == ']') && this.openers.isEmpty()) {
                    return false;
                }

                if (charOn == '}' && this.openers.remove(this.openers.size() - 1) != '{') {
                    return false;
                } else if (charOn == ']' && this.openers.remove(this.openers.size() - 1) != '[') {
                    return false;
                } else if (charOn == ')' && this.openers.remove(this.openers.size() - 1) != '(') {
                    return false;
                }
            }
        }
        
        return this.openers.isEmpty();
    }
}
