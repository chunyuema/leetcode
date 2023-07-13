/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    vector<int> distanceK(TreeNode *root, TreeNode *target, int k)
    {
        map<TreeNode *, vector<TreeNode *>> graphedTree;
        buildGraphFromTree(root, nullptr, graphedTree);
        vector<int> res;
        set<TreeNode *> visitedNodes = {target};
        dfsHelper(target, 0, k, res, visitedNodes, graphedTree);
        return res;
    }

    void dfsHelper(TreeNode *currNode, int distanceFromTarget, int k,
                   vector<int> &res, set<TreeNode *> &visitedNodes, map<TreeNode *, vector<TreeNode *>> &graphedTree)
    {
        if (distanceFromTarget == k)
        {
            res.push_back(currNode->val);
            return;
        }

        for (TreeNode *n : graphedTree[currNode])
        {
            if (visitedNodes.find(n) == visitedNodes.end())
            {
                visitedNodes.insert(n);
                dfsHelper(n, distanceFromTarget + 1, k, res, visitedNodes, graphedTree);
            }
        }
    }

    void buildGraphFromTree(TreeNode *currNode, TreeNode *parentNode, map<TreeNode *, vector<TreeNode *>> &graphedTree)
    {
        if (currNode != nullptr && parentNode != nullptr)
        {
            graphedTree[currNode].push_back(parentNode);
            graphedTree[parentNode].push_back(currNode);
        }

        if (currNode->left != nullptr)
            buildGraphFromTree(currNode->left, currNode, graphedTree);
        if (currNode->right != nullptr)
            buildGraphFromTree(currNode->right, currNode, graphedTree);
    }
};