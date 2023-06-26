package q0219;
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indexMap.containsKey(num)) {
                int j = indexMap.get(num);
                if (i - j <= k)
                    return true;
            }
            indexMap.put(num, i);
        }
        return false;
    }
}