class Solution
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        if (!root)
            return {};
        vector<vector<int>> res;
        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int n = q.size();
            vector<int> level_vals = {};
            for (int i = 0; i < n; i++)
            {
                TreeNode *node = q.front();
                q.pop();
                level_vals.push_back(node->val);
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }
            res.push_back(level_vals);
        }

        return res;
    }
};