class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLen(head);
        int n = len / k;
        int r = len % k;

        ListNode[] res = new ListNode[k];
        ListNode curr = head; 
        for (int i = 0; i < k; i++) {

            // figure out number of nodes to be included in this part
            int end = n - 1 + (i < r ? 1 : 0);

            // find the end node in the current part
            for (int j = 0; j < end; j++) {
                if (curr != null) curr = curr.next;
            }

            // if the end node of the current part is not null, then we need to update the pointers
            // in order to break the rest of the chain from this node
            if (curr != null) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = null; 
            }
            
            res[i] = head;
            head = curr;
        }

        return res;
    }

    private int getLen(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}