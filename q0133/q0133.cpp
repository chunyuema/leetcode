class Solution {
public:
    Node* cloneGraph(Node* node) {
        if (!node) return nullptr;
        std::unordered_map<Node*, Node*> res;
        return dfs(node, res);
    }

private:
    Node* dfs(Node* node, std::unordered_map<Node*, Node*>& res) {
        if (res.find(node) != res.end()) {
            return res[node];
        }
        Node* copy = new Node(node->val);
        res[node] = copy;
        for (Node* neighbor : node->neighbors) {
            copy->neighbors.push_back(dfs(neighbor, res));
        }
        return copy;
    }
};