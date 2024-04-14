# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        self.totalSum = 0
        self.dfs(root, False)
        return self.totalSum

    def dfs(self, node, isLeftChild): 
        if not node: return
        if not node.left and not node.right and isLeftChild:
            self.totalSum += node.val
            return
        self.dfs(node.left, True)
        self.dfs(node.right, False)   