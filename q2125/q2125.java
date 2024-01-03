class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0;
        int totalBeam = 0;

        for (String row : bank) {
            int currCount = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1')
                    currCount++;
            }

            // Only update the totalBeam if the row has some devices
            if (currCount != 0) {
                totalBeam += prevCount * currCount;
                // We only need to track the last count of the devices in the row
                prevCount = currCount;
            }
        }

        return totalBeam;
    }
}