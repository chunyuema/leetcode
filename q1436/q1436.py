class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        outgoingCities = set()
        for (leaveFrom, arriveAt) in paths: 
            outgoingCities.add(leaveFrom)
        
        for (leaveFrom, arriveAt) in paths: 
            if arriveAt not in outgoingCities: 
                return arriveAt