# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        self.dfsHelper(root)
        return self.diameter

    def dfsHelper(self, node):
        if not node: return 0
        l = self.dfsHelper(node.left)
        r = self.dfsHelper(node.right)
        self.diameter = max(self.diameter, l + r)
        return max(l, r) + 1
