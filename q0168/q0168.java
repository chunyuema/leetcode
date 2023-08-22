class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--; 
            int remainder = columnNumber % 26;
            sb.append((char) (remainder + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}