class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int totalLen = a + b + c;
        int runningA = 0; 
        int runningB = 0; 
        int runningC = 0;
        while (sb.length() < totalLen) {
            // Pick the most abundant character
            if ((a >= b && a >= c && runningA != 2) ||
                (a > 0 && (runningB == 2 || runningC == 2))) {
                sb.append('a');
                a--;
                runningA++;
                runningB = 0; 
                runningC = 0;
            } 
            else if ((b >= a && b >= c && runningB != 2) || 
                     (b > 0 && (runningA == 2 || runningC == 2))) {
                sb.append('b');
                b--;
                runningB++;
                runningA = 0; 
                runningC = 0;  
            } 
            else if ((c >= a && c >= b && runningC < 2) || 
                     (c > 0 && (runningA == 2 || runningB == 2))) {
                sb.append('c');
                c--;
                runningC++;
                runningA = 0; 
                runningB = 0;  
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}