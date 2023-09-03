class Solution {
    private int totalNum = 0; 
    private Character[] chars = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        backtrackHelper(n, 0, chars, 0);
        return totalNum;
    }

    private void backtrackHelper(int n, int currLen, Character[] chars, int startIdx) {
        if (currLen == n) {
            totalNum++; 
            return;
        }

        for (int i = startIdx; i < chars.length; i++) {
            currLen++;
            backtrackHelper(n, currLen, chars, i);
            currLen--;
        }
    }
}
