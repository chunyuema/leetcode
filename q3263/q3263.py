class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        # number of points which have the same y value in the coordinates
        d = defaultdict(int)
        for _, y in points: 
            d[y] += 1
        
        MOD = 10 ** 9 + 7
        res = 0
        # sum of the previous edges identified on each horizontal set of points
        edges_sums = 0
        for point_count in d.values():
            # choose any 2 points from the point set to form an unique edge
            edge_count = point_count * (point_count - 1) // 2
            # for each horizontal set of points, the edge count could form 1 new trapezoids
            # edge_count * prev1 + edge_count * prev2 + .... edge_count * prevN 
            # = eddge_count * (prev1 + prev2 + ... + prevN) = edge_count * edges_sums
            res = (res + edge_count * edges_sums) % MOD
            edges_sums += edge_count

        return res
