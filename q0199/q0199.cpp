/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        deque<TreeNode*> q;
        q.push_back(root);
        vector<int> res;
        
        while (!q.empty()) {
            int size = q.size();
            TreeNode* last = nullptr;
            for (int i = 0; i < size; ++i) {
                TreeNode* x = q.front();
                q.pop_front();
                if (x) {
                    last = x;
                    q.push_back(x->left);
                    q.push_back(x->right);
                }
            }
            if (last) {
                res.push_back(last->val);
            }
        }
        
        return res;
    }
};