class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            nums.add(currNode.val);
            currNode = currNode.next;
        }

        return nextGreaterElement(nums);

    }

    public int[] nextGreaterElement(List<Integer> nums) {
        int[] res = new int[nums.size()];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.size(); i++) {
            int currNum = nums.get(i);
            while (!stack.isEmpty() && currNum > nums.get(stack.peek())) {
                int prevNumIndex = stack.pop();
                res[prevNumIndex] = currNum;
            }
            stack.push(i);
        }
        return res;
    }
}