class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShift = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            rightShift++;
        }

        // left OR right now represent the common prefix of the
        // binary representation of original left and right number
        return left << rightShift;
    }
}