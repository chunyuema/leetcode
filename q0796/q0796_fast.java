class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are equal
        if (s.length() != goal.length()) return false;
        
        // Concatenate s with itself
        String doubleS = s + s;
        
        // Check if goal is a substring of the concatenated string
        return doubleS.contains(goal);
    }
}

