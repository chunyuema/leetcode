# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:

        # track the max diff we see during the dfs
        self.maxDiff = 0

        def dfsHelper(node, maxPrev, minPrev): 
            if node == None: return
            currVal = node.val

            # max diff is either constructed by curr val - the max / min of it ancestor
            currDiff = max(abs(maxPrev - currVal), abs(minPrev - currVal))
            self.maxDiff = max(currDiff, self.maxDiff)

            # update the max and min of ancestor before recursing
            maxPrev = max(currVal, maxPrev)
            minPrev = min(currVal, minPrev)

            # recursively deal with the left and right subtree
            dfsHelper(node.left, maxPrev, minPrev)
            dfsHelper(node.right, maxPrev, minPrev)
        
        dfsHelper(root, root.val, root.val)
        return self.maxDiff
        