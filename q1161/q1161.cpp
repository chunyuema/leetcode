#include <queue>
using namespace std;

class Solution
{
public:
    int maxLevelSum(TreeNode *root)
    {

        int currMaxSum = root->val;
        int currLevel = 1, maxSumLevel = 1;

        // Initialize the queue for BFS
        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int num = q.size();
            int levelSum = 0;
            for (int i = 0; i < num; i++)
            {
                TreeNode *node = q.front();
                levelSum += node->val;
                if (node->left != nullptr)
                    q.push(node->left);
                if (node->right != nullptr)
                    q.push(node->right);
                q.pop();
            }
            if (levelSum > currMaxSum)
            {
                maxSumLevel = currLevel;
                currMaxSum = levelSum;
            }
            currLevel++;
        }
        return maxSumLevel;
    }
};

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};