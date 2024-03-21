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
class Solution
{
public:
    ListNode *reverseList(ListNode *head)
    {
        ListNode *prev_n = NULL;
        ListNode *curr_n = head;
        ListNode *next_n = NULL;
        while (curr_n)
        {
            next_n = curr_n->next;
            curr_n->next = prev_n;
            prev_n = curr_n;
            curr_n = next_n;
        }
        return prev_n;
    }
};