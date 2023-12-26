class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i - 2) == num.charAt(i) && num.charAt(i - 1) == num.charAt(i)) {
                if (result.length() == 0 || num.charAt(i) > result.charAt(0)) {
                    result = num.substring(i - 2, i + 1);
                }
            }
        }
        return result;
    }
}