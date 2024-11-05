class Solution {
    public int minChanges(String s) {
        int prevCount = 0;            // This variable is unused and can be removed. It is initialized but never used in logic.
        Character prevChar = null;    // Variable to store the previous character as we loop through the string.
        
        int minFlipCount = 0;         // This will count the minimum number of flips needed.
        
        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Get the current character at index 'i'
            Character currChar = s.charAt(i);
            
            // If this is the first character (prevChar is null), initialize prevChar to the current character.
            if (prevChar == null) {
                prevChar = currChar;  // Set the previous character to the current one.
                prevCount = 1;        // prevCount is unnecessary, it is initialized here but never used.
                continue;             // Skip the rest of the loop and move to the next character.
            }
            
            // If the current character is different from the previous character, increment flip count.
            if (currChar != prevChar) {
                minFlipCount++;  // We need to flip the current character to make it the same as the previous.
            }
            
            // After checking the current character, update prevChar to the current character for the next iteration.
            prevChar = null;  // Reset prevChar to null, which is an issue in the original code.
            prevCount = 0;    // Reset prevCount (also unused).
        }
        
        // Return the final count of flips needed to make adjacent characters the same.
        return minFlipCount;
    }
}

