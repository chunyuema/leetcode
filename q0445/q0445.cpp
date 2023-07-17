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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        stack<int> s1;
        stack<int> s2;
        while (l1 != nullptr)
        {
            s1.push(l1->val);
            l1 = l1->next;
        }

        while (l2 != nullptr)
        {
            s2.push(l2->val);
            l2 = l2->next;
        }

        int currSum = 0;
        int carry = 0;
        ListNode *sumNode = new ListNode();
        while (!s1.empty() || !s2.empty())
        {
            if (!s1.empty())
            {
                currSum += s1.top();
                s1.pop();
            }

            if (!s2.empty())
            {
                currSum += s2.top();
                s2.pop();
            }

            sumNode->val = currSum % 10;
            carry = currSum / 10;

            ListNode *newSumNode = new ListNode(carry, sumNode);
            sumNode = newSumNode;

            currSum = carry;
        }

        return sumNode->val == 0 ? sumNode->next : sumNode;
    }
};