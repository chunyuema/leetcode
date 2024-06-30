class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int totalLen = a + b + c;
        int[] counts = {a, b, c};
        char[] chars = {'a', 'b', 'c'};
        
        while (sb.length() < totalLen) {
            int idx = -1;
            for (int i = 0; i < 3; i++) {
                
                // Find the index of the most abundant character that can be used
                if ((idx == -1 || counts[i] > counts[idx]) && 
                    // condition 1: still has quota left to be used
                    (counts[i] > 0) &&                          
                    // condition 2: use less then 2 times in a row
                    (sb.length() < 2 || (sb.charAt(sb.length() - 1) != chars[i] || 
                      (sb.charAt(sb.length() - 2) != chars[i])))) {
                    idx = i;
                }
            }
            
            if (idx == -1) break;
            
            sb.append(chars[idx]);
            counts[idx]--;
        }
        
        return sb.toString();
    }
}