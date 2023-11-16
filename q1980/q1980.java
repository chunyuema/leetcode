class Solution {
    private String backtrack(String curr, Set<String> bsSet, int targetLen) {
        if (curr.length() == targetLen) {
            if (!bsSet.contains(curr))
                return curr;
            else
                return "";
        }

        // add zero to the current binary string
        String res0 = backtrack(curr + "0", bsSet, targetLen);
        if (res0.length() > 0)
            return res0;

        // add one to the current binary string
        String res1 = backtrack(curr + "1", bsSet, targetLen);
        return res1;
    }

    public String findDifferentBinaryString(String[] nums) {
        int targetLen = nums[0].length();
        Set<String> bsSet = new HashSet<>();
        for (String s : nums)
            bsSet.add(s);
        return backtrack("", bsSet, targetLen);
    }
}