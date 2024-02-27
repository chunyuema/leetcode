class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.currSum = 0
        self.dfsHelper(root)
        return root
    
    def dfsHelper(self, node):
        if not node: return
        self.dfsHelper(node.right)
        self.currSum += node.val
        node.val = self.currSum
        self.dfsHelper(node.left)
        return 