class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        max_sum = root.val
        max_level = 1
        curr_level = 1

        queue = [root]
        while queue:
            count = len(queue)
            level_sum = 0
            for _ in range(count):
                curr_node = queue.pop(0)
                level_sum += curr_node.val
                if curr_node.left: queue.append(curr_node.left)
                if curr_node.right: queue.append(curr_node.right) 
            if level_sum > max_sum:
                max_sum = level_sum
                max_level = curr_level
            curr_level += 1
        return max_level
