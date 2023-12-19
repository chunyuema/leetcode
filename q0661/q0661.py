class Solution(object):
    def imageSmoother(self, img):
        """
        :type img: List[List[int]]
        :rtype: List[List[int]]
        """
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], 
                [1, 1], [1, -1], [-1, 1], [-1, -1]]
        
        m, n = len(img), len(img[0])
        smoothedImg = [[0] * n for _ in range(m)]
        for i in range(m): 
            for j in range(n):
                sum = img[i][j]
                count = 1
                for dir in dirs: 
                    nextI, nextJ = i + dir[0], j + dir[1]
                    if (nextI >= 0 and nextI < m and
                        nextJ >= 0 and nextJ < n): 
                        sum += img[nextI][nextJ]
                        count += 1
                smoothedImg[i][j] = sum // count
        return smoothedImg
                
        