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
    int minDepth(TreeNode *root)
    {
        if (!root)
            return 0;
        queue<TreeNode *> q;
        q.push(root);
        int depth = 1;
        while (!q.empty())
        {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++)
            {
                TreeNode *currNode = q.front();
                q.pop();
                if (!currNode->left && !currNode->right)
                {
                    return depth;
                }
                if (currNode->left)
                    q.push(currNode->left);
                if (currNode->right)
                    q.push(currNode->right);
            }
            depth++;
        }
        return 0;
    }
};