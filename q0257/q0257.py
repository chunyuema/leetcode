class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []

        def getPaths(node, currPath):
            if not node:
                return
            if not node.left and not node.right:
                res.append(currPath + str(node.val))
                return
            getPaths(node.left, currPath + str(node.val) + '->')
            getPaths(node.right, currPath + str(node.val) + '->')

        getPaths(root, "")
        return res
