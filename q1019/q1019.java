class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            nums[i] = list.get(i);
        return nextGreaterElement(nums);

    }

    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            while (!stack.isEmpty() && currNum > nums[stack.peek()]) {
                int prevNumIndex = stack.pop();
                res[prevNumIndex] = currNum;
            }
            stack.push(i);
        }
        return res;
    }
}