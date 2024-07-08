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
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        int prevVal = head->val;
        head = head->next;
        int i = 2;
        int minDis = INT_MAX;
        int prevPos = -1;
        int firstCriticPoint = 0;

        while (head->next != nullptr) {
            int cur = head->val;
            if ((prevVal < cur && cur > head->next->val) || (prevVal > cur && cur < head->next->val)) {
                if (prevPos != -1) {
                    minDis = std::min(minDis, i - prevPos);
                } else {
                    firstCriticPoint = i;
                }
                prevPos = i;
            }
            prevVal = cur;
            head = head->next;
            i += 1;
        }

        return (minDis != INT_MAX) ? std::vector<int>{ minDis, prevPos - firstCriticPoint} : std::vector<int>{ -1, -1 }; 
    }
};