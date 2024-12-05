class Solution {
    public boolean canChange(String start, String target) {
        int len = start.length();
        int startIndex = 0; 
        int targetIndex = 0;

        // Use this condition since one of the pointers will travel to the end of the string first
        while (startIndex < len || targetIndex < len) {
            // Search for the upcoming char (either 'L' or 'R')
            while (startIndex < len && start.charAt(startIndex) == '_') startIndex++;
            while (targetIndex < len && target.charAt(targetIndex) == '_') targetIndex++;
            
            // Handler overflow: Both index will exhaust at the same time
            if (startIndex == len || targetIndex == len) return startIndex == targetIndex;
            
            char startChar = start.charAt(startIndex);
            char targetChar = target.charAt(targetIndex);
            // Two index must be pointing to the same character at any given time
            if (startChar != targetChar) return false;
            // If a L character moved right, return false
            if (startChar == 'L' && targetIndex > startIndex) return false;
            // If a R character moved left, return false
            if (startChar == 'R' && targetIndex < startIndex) return false;

            startIndex++; 
            targetIndex++;
        }
        return true;
    }
}