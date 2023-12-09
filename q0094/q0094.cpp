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
class Solution
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> vals;
        dfsHelper(root, vals);
        return vals;
    }

private:
    void dfsHelper(const TreeNode *node, vector<int> &vals)
    {
        if (node == nullptr)
            return;
        dfsHelper(node->left, vals);
        vals.push_back(node->val);
        dfsHelper(node->right, vals);
    }
};