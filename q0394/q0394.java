package q0394;
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String currNum = "";
        String currStr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                int num = currNum.equals("") ? 0 : Integer.parseInt(currNum);
                intStack.push(num);
                currNum = "";

                strStack.push(currStr);
                currStr = "";
            } else if (c == ']') {
                Integer num = intStack.pop();
                String prevStr = strStack.pop();
                currStr = prevStr + currStr.repeat(num);
            } else if (Character.isDigit(c)) {
                currNum += c;
            } else {
                currStr += c;
            }
        }
        return currStr;
    }
}