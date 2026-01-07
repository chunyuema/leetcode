class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        MOD = 10**9 + 7
        self.max_product = 0

        # First pass: compute total sum
        self.total_sum = self.tree_sum(root)

        # Second pass: compute max product
        self.subtree_sum(root)

        return self.max_product % MOD

    def tree_sum(self, node):
        if not node:
            return 0
        return node.val + self.tree_sum(node.left) + self.tree_sum(node.right)

    # same as tree_sum, but update max_product along the way
    def subtree_sum(self, node):
        if not node:
            return 0

        left = self.subtree_sum(node.left)
        right = self.subtree_sum(node.right)

        curr_sum = node.val + left + right
        self.max_product = max(
            self.max_product,
            curr_sum * (self.total_sum - curr_sum)
        )
        return curr_sum

