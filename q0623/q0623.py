# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1: return TreeNode(val, root, None)
        self.dfs(root, val, 1, depth)
        return root
    
    def dfs(self, node, val, currDepth, depth):
        # If there is no node, or if the curreDepth exceeds the depth where we want to insert row
        if not node or currDepth >= depth: return

        # If the next depth is the row where we want to insert
        if currDepth + 1 == depth:
            node.left = TreeNode(val, node.left, None)
            node.right = TreeNode(val, None, node.right)

        self.dfs(node.left, val, currDepth+1, depth)
        self.dfs(node.right, val, currDepth+1, depth)
        