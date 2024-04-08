class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:

        squareStudent = sum(students) 
        circleStudent = len(students) - squareStudent
        
        for sandwich in sandwiches: 
            if sandwich == 0 and circleStudent == 0: return squareStudent
            elif sandwich == 1 and squareStudent == 0: return circleStudent

            elif sandwich == 0: circleStudent -= 1
            else: squareStudent -= 1
        
        return 0