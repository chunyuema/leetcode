class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        self.graph = defaultdict(list)
        self.max_components = 0

        for u, v in edges:
            self.graph[u].append(v)
            self.graph[v].append(u)

        # Start DFS from node 0, with parent = -1
        self.dfs_helper(0, -1, values, k)
        return self.max_components
    
    def dfs_helper(self, curr, parent, values, k):
        # Compute subtree sum with root node at curr 
        curr_sum = values[curr]

        for nxt in self.graph[curr]:
            if nxt != parent:
                curr_sum += self.dfs_helper(nxt, curr, values, k)

        # If a parent tree sum % k = 0, and it contains a subtree sum % k = 0
        # Then both subtree component, and (bigger parent tree - subtree) component should be counted
        # Hence whenever curr_sum % k == 0, eagerly add 1 to max_components
        if curr_sum % k == 0:
            self.max_components += 1
            # Optionally terminating this recursion, return 0
            return 0
        
        return curr_sum
