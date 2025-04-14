package warmups;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) {
            return;
        }

        // Two pointers method
        // Go through the array
            // swap the char at front and back
            // if the index is the same or 1 away from each other return the array
        for (int i = 0; i < s.length; i++) {
            int pointerTwo = s.length - i - 1;

            char firstChar = s[i];
            char secondChar = s[pointerTwo];
            s[i] = secondChar;
            s[pointerTwo] = firstChar;

            // Met in middle
            if (i == pointerTwo || i == pointerTwo - 1) {
                return;
            }
        }
    }
}