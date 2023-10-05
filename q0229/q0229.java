class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer num1 = Integer.MIN_VALUE;
        Integer num2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
            else if (count1 == 0) {
                num1 = num;
                count1++;
            } else if (count2 == 0) {
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(num1);
        if (count2 > nums.length / 3)
            res.add(num2);
        return res;
    }
}