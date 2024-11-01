class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0); 
        int count = 1; 
        StringBuilder sb = new StringBuilder();
        sb.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                if (count < 2) {
                   sb.append(curr);
                   count++; 
                } 
                // else ignore the character
            } else {
                sb.append(curr);
                prev = curr;
                count = 1;
            }
        }

        return sb.toString();
    }
}