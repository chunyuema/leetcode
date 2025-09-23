class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        decomposedVersion1 = version1.split('.')
        decomposedVersion2 = version2.split('.')

        i = 0
        while i < len(decomposedVersion1) and i < len(decomposedVersion2):
            partV1 = int(decomposedVersion1[i])
            partV2 = int(decomposedVersion2[i])
            if partV1 < partV2: 
                return -1
            elif partV1 > partV2: 
                return 1
            i += 1
            
        while i < len(decomposedVersion1):
            partV1 = int(decomposedVersion1[i])
            if partV1 != 0:
                return 1
            i += 1
        
        while i < len(decomposedVersion2):
            partV2 = int(decomposedVersion2[i])
            if partV2 != 0:
                return -1
            i += 1
        
        return 0