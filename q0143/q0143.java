/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void mergeList(ListNode p1, ListNode p2) {
        while (p2 != null) {
            // Take the reference of the next of p1
            ListNode next = p1.next;

            // Always merge in from p2: p1.next should not be p2
            p1.next = p2;

            // Swap p1 and p2 so we aways merge from p2
            p1 = p2;

            // p2 not is the next
            p2 = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = head;
        ListNode l2 = reverseList(slow);
        mergeList(l1, l2);
    }
}