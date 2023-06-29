#include <unordered_map>
#include <utility>
#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
    double maxProbability(int n, vector<vector<int>> &edges, vector<double> &succProb, int start, int end)
    {
        // Construct graph
        unordered_map<int, vector<pair<int, double>>> graph;
        for (int i = 0; i < edges.size(); i++)
        {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            double prob = succProb[i];
            if (graph.find(n1) != graph.end())
            {
                graph[n1].push_back({n2, prob});
            }
            else
            {
                graph[n1] = vector<pair<int, double>>{{n2, prob}};
            }

            if (graph.find(n2) != graph.end())
            {
                graph[n2].push_back({n1, prob});
            }
            else
            {
                graph[n2] = vector<pair<int, double>>{{n1, prob}};
            }
        }

        // Record the max probability from start to every node in the graph
        vector<double> maxProbToNode(n, 0);
        maxProbToNode[start] = 1;

        // Start from start, do breadth first search to exhaust all possible ways all nodes from start
        queue<int> q;
        q.push(start);
        while (!q.empty())
        {
            int currNode = q.front();
            q.pop();
            vector<pair<int, double>> neighbors = graph[currNode];
            if (!neighbors.empty())
            {
                for (pair<int, double> n : neighbors)
                {
                    int nextNode = n.first;
                    double probToNextNode = n.second;
                    double newMaxProbToNextNode = maxProbToNode[currNode] * probToNextNode;
                    // Note that only if there the new probability of reaching this node is bigger than its current max probability, there is a point of pushing it on to the queue and keep exploring it in the future.
                    if (newMaxProbToNextNode > maxProbToNode[nextNode])
                    {
                        maxProbToNode[nextNode] = newMaxProbToNextNode;
                        q.push(nextNode);
                    }
                }
            }
        }

        return maxProbToNode[end];
    }
};