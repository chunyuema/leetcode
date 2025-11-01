/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        while (curr != null) {
            if (numSet.contains(curr.val)) {
                prev.next = curr.next; 
                curr = curr.next;
            } else {
                prev = curr; 
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
