class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox = new char[n][m];

        for (char[] row : rotatedBox) Arrays.fill(row, '.');

        for (int i = 0; i < m; i++) {
            int nextAvailableSlot = n - 1;
            for (int j = n-1; j >= 0; j--) {
                // If it is a stone, it will fall to the next available slot
                if (box[i][j] == '#') {
                    rotatedBox[nextAvailableSlot][m - i - 1] = '#';
                    nextAvailableSlot--;
                }
                // If it is an obstacle, it will change the next available slot
                else if (box[i][j] == '*') {
                    rotatedBox[j][m - i - 1] = '*';
                    nextAvailableSlot = j - 1;
                }
                // If it is emtpy, then we do not need to do anything
                // else { pass }
            }
        }

        return rotatedBox;
    }
}