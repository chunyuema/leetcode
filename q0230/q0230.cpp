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
    int kthSmallest(TreeNode *root, int k)
    {
        stack<TreeNode *> node_stack;
        while (true)
        {
            // go all the way to the left most element
            while (root)
            {
                node_stack.push(root);
                root = root->left;
            }
            root = node_stack.top();
            k--;
            if (k == 0)
                return root->val;
            node_stack.pop();
            root = root->right;
        }
    }
};