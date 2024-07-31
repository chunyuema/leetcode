class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<bool> ans;
        unordered_map<int, vector<int>> adj;
        unordered_map<int, unordered_set<int>> prereq;

        // Build adjacency list
        for (const auto& edge : prerequisites) {
            adj[edge[0]].push_back(edge[1]);
        }

        // Define the dfs function as a lambda
        auto dfs = [&](int src, auto&& dfs_ref) -> unordered_set<int> {
            if (prereq.find(src) == prereq.end()) {
                prereq[src] = unordered_set<int>();
                for (int neigh : adj[src]) {
                    prereq[src].insert(dfs_ref(neigh, dfs_ref).begin(), dfs_ref(neigh, dfs_ref).end());
                }
                prereq[src].insert(src);
            }
            return prereq[src];
        };

        // Perform DFS for each course
        for (int i = 0; i < numCourses; ++i) {
            dfs(i, dfs);
        }

        // Answer the queries
        for (const auto& query : queries) {
            int u = query[0], v = query[1];
            ans.push_back(prereq[u].count(v) > 0);
        }

        return ans; 
    }
};