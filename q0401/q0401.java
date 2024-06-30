class Solution {

    final int[] vals = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
    final boolean[] isOn = new boolean[10];

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> readings = new LinkedList<String>();
        backtrackHelper(turnedOn, 0, readings);
        return readings;
    }

    private void backtrackHelper(int left, int start, List<String> readings) {

        // Update the readings array when there is no more lights left
        if (left == 0) {
            // Get the hours
            int currHour = 0;
            for (int i = 0; i < 4; i++) {
                if (isOn[i] == true) {
                    currHour += vals[i];
                }
            }
            if (currHour >= 12) return;

            // Get the minutes
            int currMin = 0; 
            for (int i = 4; i < 10; i++) {
                if (isOn[i] == true) {
                    currMin += vals[i];
                }
            }
            if (currMin >= 60) return;

            // Construct the solution
            StringBuilder time = new StringBuilder();
            time.append(currHour).append(":");
            if (currMin < 10) time.append("0");
            time.append(currMin);
            readings.add(0, time.toString());
            return;
        }

        for (int i = start; i < isOn.length; i++) {
            isOn[i] = true;
            // Starting from i+1 since combination (no repeats allowed)
            backtrackHelper(left - 1, i + 1, readings);
            isOn[i] = false;
        }
    }
}