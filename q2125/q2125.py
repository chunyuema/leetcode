class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        prevCount = 0
        totalBeam = 0
        for row in bank:
            currCount = 0 
            for cell in row: 
                if cell == "1": currCount += 1
            # Only update the totalBeam if the row has some devices
            if currCount != 0: 
                totalBeam += currCount * prevCount
                # We only need to track the last count of the devices in the row
                prevCount = currCount
        return totalBeam