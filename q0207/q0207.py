class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preReqMap = {}
        for i in range(numCourses):
            preReqMap[i] = []
        for course, preReqCourse in prerequisites:
            preReqMap[course].append(preReqCourse)

        visitedCourse = set()

        def dfsCheckCycle(course):
            if course in visitedCourse:
                return False
            if preReqMap[course] == []:
                return True

            visitedCourse.add(course)
            for preReq in preReqMap[course]:
                if not dfsCheckCycle(preReq):
                    return False
            visitedCourse.remove(course)
            preReqMap[course] = []
            return True

        for course in range(numCourses):
            if not dfsCheckCycle(course):
                return False
        return True
