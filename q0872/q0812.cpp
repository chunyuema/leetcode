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
    bool leafSimilar(TreeNode *root1, TreeNode *root2)
    {
        // Call DFS to get the leaves of tree 1:
        vector<int> tree1Leaves;
        dfsHelper(root1, tree1Leaves);

        // Call DFS to get the leaves of tree 2:
        vector<int> tree2Leaves;
        dfsHelper(root2, tree2Leaves);

        // Compare if the leaves are the same
        return tree1Leaves == tree2Leaves;
    }

private:
    void dfsHelper(const TreeNode *root, vector<int> &leaves)
    {
        if (root == NULL)
            return;
        if (root->left == NULL && root->right == NULL)
        {
            leaves.push_back(root->val);
            return;
        }
        dfsHelper(root->left, leaves);
        dfsHelper(root->right, leaves);
    }
};