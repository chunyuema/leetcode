# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        self.smallest = ""
        self.dfs(root, "")
        return self.smallest
        
    def dfs(self, node, currString):
        if not node:
            return
        
        currString = chr(ord('a') + node.val) + currString
        if not node.left and not node.right:
            if self.smallest == "" or self.smallest > currString:
                self.smallest = currString
            return
        
        self.dfs(node.left, currString)
        self.dfs(node.right, currString)