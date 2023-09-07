class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;

        for (int i = 0; i < left - 1; i++) prev = prev.next;

        // reverse the relevant segment of the linked list by switching the curr one by one
        // until it reaches the end of the segment that we would like to reverse
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }

        return dummy.next;
    }
}