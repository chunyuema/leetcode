class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        vector<string> ans;
        unordered_map<string, vector<string>> adj;
        unordered_map<string, int> indegree;
        
        for (int i = 0; i < recipes.size(); ++i) {
            indegree[recipes[i]] = ingredients[i].size();
            for (const string& ingredient : ingredients[i]) {
                adj[ingredient].push_back(recipes[i]);
            }
        }
        
        queue<string> q;
        for (const string& supply : supplies) {
            q.push(supply);
        }
        
        while (!q.empty()) {
            string supply = q.front();
            q.pop();
            if (find(recipes.begin(), recipes.end(), supply) != recipes.end()) {
                ans.push_back(supply);
            }
            for (const string& recipe : adj[supply]) {
                indegree[recipe]--;
                if (indegree[recipe] == 0) {
                    q.push(recipe);
                }
            }
        }
        
        return ans;   
    }
};