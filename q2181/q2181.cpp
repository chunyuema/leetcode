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
    ListNode* mergeNodes(ListNode* head) {
        head = head->next; // Skip the initial zero node
        ListNode* newList = new ListNode();
        ListNode* newHead = newList;
        int sum = 0;
        
        while (head != nullptr) {
            sum += head->val;
            if (head->val == 0) {
                newList->next = new ListNode(sum);
                newList = newList->next;
                sum = 0;
            }
            head = head->next;
        }
        
        return newHead->next;
    }
};