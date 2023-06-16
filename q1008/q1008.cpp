#include <vector>
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
    TreeNode *bstFromPreorder(vector<int> &preorder)
    {
        return bstConstructor(preorder, 0, preorder.size() - 1);
    }

    TreeNode *bstConstructor(vector<int> &preorder, int l, int r)
    {
        if (l > r)
            return nullptr;
        int rootVal = preorder[l];
        int m;
        for (m = l; m <= r; m++)
        {
            if (preorder[m] > rootVal)
                break;
        }
        TreeNode *leftBst = bstConstructor(preorder, l + 1, m - 1);
        TreeNode *rightBst = bstConstructor(preorder, m, r);
        TreeNode *bst = new TreeNode(rootVal, leftBst, rightBst);
        return bst;
    }
};