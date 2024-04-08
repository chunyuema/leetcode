class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudent = 0;
        int squareStudent = 0;
        for (int student : students) {
            if (student == 0)
                circleStudent++;
            else
                squareStudent++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && circleStudent == 0)
                return squareStudent;
            if (sandwich == 1 && squareStudent == 0)
                return circleStudent;

            if (sandwich == 0)
                circleStudent--;
            else
                squareStudent--;
        }
        return 0;
    }
}