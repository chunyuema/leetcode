# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # Update the total sum whenever we hit a leaf node
        self.totalSum = 0
        self.dfs(root, 0)
        return self.totalSum
    
    def dfs(self, node, curr):
        if not node: return 

        # Update the curr number formed by the path so far
        curr = curr * 10 + node.val
        if not node.left and not node.right:
            self.totalSum += curr
            return
        
        # Recurse on the left and right tree
        self.dfs(node.left, curr)
        self.dfs(node.right, curr)