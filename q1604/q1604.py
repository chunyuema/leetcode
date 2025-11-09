class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        d = {}
        for i in range(len(keyName)):
            name = keyName[i]
            time = keyTime[i]
            if name not in d: d[name] = [time]
            else: d[name] += [time]
                
        workers = []       
        for name, accesses in d.items():
            # Only need to check if there are more than 3 accesses
            if len(accesses) >=3:
                accesses = sorted(accesses)
                for i in range(len(accesses)-2):
                    if self.isAlerted(accesses[i+2], accesses[i]):
                        workers.append(name)
                        # Early break, no need to check further for this name
                        break

        # Return alphabetically sorted names
        return sorted(workers)

    # Returne True if time1-time2 within 1 hour, else False
    def isAlerted(self, time1: str, time2: str) -> bool:
        # If the hours differ more than 1: not alerted
        if int(time1[:2]) - int(time2[:2]) > 1: 
            return False
        # If the housrs deffers by 1, and within 60 minutes: not alerted
        elif (int(time1[:2])-int(time2[:2]) == 1) and (int(time1[-2:]) > int(time2[-2:])): 
            return False
        # Alerted
        return True
