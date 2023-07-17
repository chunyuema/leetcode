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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int currSum = 0;
        int carry = 0;
        ListNode sumHead = new ListNode();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            currSum += n1 + n2;

            sumHead.val = currSum % 10;
            carry = currSum / 10;

            ListNode newSumHead = new ListNode(carry, sumHead);
            sumHead = newSumHead;

            currSum = carry;
        }
        return sumHead.val == 0 ? sumHead.next : sumHead;
    }
}