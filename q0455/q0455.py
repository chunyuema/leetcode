def findContentChildren(g: List[int], s: List[int]) -> int:
    s.sort()
    g.sort()
    childIndex = cookieIndex = 0
    while childIndex < len(g) and cookieIndex < len(s):
        if s[cookieIndex] >= g[childIndex]:
            childIndex += 1
        # update the cookieIndex 
        # case 1: satisfied the kid and need a new cookie for the next kid
        # case 2: kid's greed factor larger than current cookie, need a bigger cookie
        cookieIndex += 1
    return childIndex
