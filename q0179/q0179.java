import java.util.*;
import java.util.Comparator;

class Solution {
    private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            return (y + x).compareTo(x + y);
        }
    }

    public String largestNumber(int[] nums) {
        List<String> resList = new ArrayList<>();
        for (int num : nums) {
            resList.add(String.valueOf(num));
        }
        Collections.sort(resList, new MyComparator());
        String res = new String();
        for (String s : resList) {
            res += s;
        }
        if (res.charAt(0) == '0')
            return "0";
        return res;
    }
}