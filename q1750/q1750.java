class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // If either the left / right pointer points to different character, break
            int currChar = s.charAt(left);
            if (currChar != s.charAt(right))
                break;
            // Move the left pointer as much as possible
            while (left <= right && s.charAt(left) == currChar)
                left += 1;
            // Move the right pointer as much as possible
            while (right > left && s.charAt(right) == currChar)
                right -= 1;
        }
        return right - left + 1;
    }
}