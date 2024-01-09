# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        tree1Leaves, tree2Leaves = [], []
        self.dfsHelper(root1, tree1Leaves)
        self.dfsHelper(root2, tree2Leaves)
        return tree1Leaves == tree2Leaves
    

    def dfsHelper(self, root, leaves):
        if not root: return
        if not root.left and not root.right: 
            leaves.append(root.val)
            return 
        self.dfsHelper(root.left, leaves)
        self.dfsHelper(root.right, leaves)