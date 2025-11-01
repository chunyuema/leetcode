# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        numSet = set(nums)
        # Use this dummy to track the head of the link list
        dummy = ListNode(0, head)

        # Set prev to point at dummy, and curr to point at head
        prev = dummy
        curr = head

        while (curr != None):
            # No need to remove node, update prev and curr by moving them forward by 1
            if (curr.val not in numSet):
                prev = curr
                curr = curr.next
            # Need to remove node, prev.next now points to curr.next, then move curr forward by 1
            else:
                prev.next = curr.next
                curr = curr.next
        
        # Original head might not be the correct new head as it might have been removed
        # dummy.next will be pointing to the correct head of the new linked list
        return dummy.next
