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
    string tree2str(TreeNode *root)
    {
        string res = "";
        dfsHelper(root, res);
        return res;
    }

private:
    void dfsHelper(TreeNode *node, string &res)
    {

        // base case 1: node is null
        if (node == nullptr)
            return;

        res += to_string(node->val);

        // base case 2: node is leaf node
        if (node->left == nullptr && node->right == nullptr)
        {
            return;
        }

        // recurse on the left
        res += "(";
        dfsHelper(node->left, res);
        res += ")";

        // recurse on the right
        if (node->right != nullptr)
        {
            res += "(";
            dfsHelper(node->right, res);
            res += ")";
        }
    }
};
