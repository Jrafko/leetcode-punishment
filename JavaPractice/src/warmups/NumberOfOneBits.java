package warmups;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        // n is 0 or n is 1  
        if (n == 0 || n == 1) {
            return n;
        }

        int oneCount = 0;
        // Convert the int to a binary representation
        String binaryN = Integer.toBinaryString(n);
        for (int curChar = 0; curChar < binaryN.length(); curChar++) {
            if (binaryN.charAt(curChar) == '1') {
                oneCount++;
            }
        }
        
        return oneCount;
    }
}
