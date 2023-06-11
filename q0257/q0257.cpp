#include <vector>
#include <string>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    vector<string> binaryTreePaths(TreeNode *root)
    {
        vector<string> res;
        getPaths(root, res, "");
        return res;
    }

    void getPaths(TreeNode *node, vector<string> &res, string currPath)
    {
        if (node == NULL)
            return;
        if (node->left == NULL && node->right == NULL)
        {
            res.push_back(currPath + to_string(node->val));
            return;
        }
        getPaths(node->left, res, currPath + to_string(node->val) + "->");
        getPaths(node->right, res, currPath + to_string(node->val) + "->");
    }
};