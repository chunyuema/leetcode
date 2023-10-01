class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0; 

        for (int i = 0; i < chars.length; i++) {
            // determine if we have reached the end of a word
            if (chars[i] == ' ' || i == chars.length - 1) {

                // set end index to be at the ' ' or len + 1
                int end = i; 
                if (i == chars.length - 1 && chars[i] != ' ') end++;

                // reverse the word bounded by start and end
                reverse(chars, start, end);

                // adjust the start appropriately
                start = i + 1;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end - 1];
            chars[end - 1] = temp;
            start++;
            end--;
        }
    }
}