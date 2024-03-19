class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        records = []
        for i, row in enumerate(mat): 
            soldierCount = sum(row)
            records.append((soldierCount, i))
        # sort by number of soldiers first, then index of the row
        records.sort()

        # take the first k records
        res = []
        for i in range(k): res.append(records[i][1])
        return res