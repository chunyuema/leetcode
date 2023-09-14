class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // find the mid point of the linked list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // get the mid point, and cut the first half and second half of the linked list
        ListNode mid = slow.next;
        slow.next = null;

        // recursively sort the left and right half before merging them together
        ListNode leftSortedList = sortList(head);
        ListNode rightSortedList = sortList(mid);
        return merge(leftSortedList, rightSortedList);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null)
            current.next = l2;
        if (l2 == null)
            current.next = l1;

        return dummy.next;
    }
}