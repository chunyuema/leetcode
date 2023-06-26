package q0228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            int end = nums[i];
            if (end == start)
                res.add(Integer.toString(start));
            else
                res.add(start + "->" + end);
        }
        return res;
    }
}