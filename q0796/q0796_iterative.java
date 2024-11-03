class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are equal
        if (s.length() != goal.length()) return false;

        int n = s.length();
        // Check each rotation
        for (int j = 0; j < n; j++) {
            if (isRotation(s, goal, j, n)) return true;
        }
        return false;
    }

    private boolean isRotation(String s, String goal, int j, int n) {
        // Check if characters match for this rotation
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt((j + i) % n)) return false;
        }
        return true;
    }
}

