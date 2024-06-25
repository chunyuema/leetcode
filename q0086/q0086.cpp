/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (head == nullptr) {
            return head;
        }
        
        ListNode great, small;
        ListNode* greatPtr = &great;
        ListNode* smallPtr = &small;
        
        while (head != nullptr) {
            if (head->val < x) {
                smallPtr->next = new ListNode(head->val);
                smallPtr = smallPtr->next;
            } else {
                greatPtr->next = new ListNode(head->val);
                greatPtr = greatPtr->next;
            }
            head = head->next;
        }
        
        smallPtr->next = great.next;
        return small.next;
    }
};