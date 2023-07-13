class Solution
{
public:
    vector<int> eventualSafeNodes(vector<vector<int>> &graph)
    {
        int n = graph.size();
        vector<bool> isChecked(n);
        vector<bool> isInvestigating(n);

        for (int i = 0; i < n; i++)
        {
            checkCycle(i, graph, isChecked, isInvestigating);
        }

        vector<int> safeNodes;
        for (int i = 0; i < n; i++)
        {
            if (!isInvestigating[i])
            {
                safeNodes.push_back(i);
            }
        }

        return safeNodes;
    }

    bool checkCycle(int currNode, const vector<vector<int>> &graph, vector<bool> &isChecked, vector<bool> &isInvestigating)
    {
        // If a node is already under investigation, it is in a cycle
        if (isInvestigating[currNode])
            return true;

        // If a node is already visited, then it is not in a cycle
        if (isChecked[currNode])
            return false;

        // Mark the currNode as checked
        isChecked[currNode] = true;

        // Mark the currNode as under investigation
        isInvestigating[currNode] = true;

        // Recursively check all the neighboring nodes
        for (int neighborNode : graph[currNode])
        {
            // If any neighboring node lead to a loop, there is a loop from the currNode, we return true from here
            // Note that since we return true, the currNode will not be marked back as false for under investigation
            if (checkCycle(neighborNode, graph, isChecked, isInvestigating))
            {
                return true;
            }
        }

        // Mark the currNode as no longer under investigation
        isInvestigating[currNode] = false;

        return false;
    }
};