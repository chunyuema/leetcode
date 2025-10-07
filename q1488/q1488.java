class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        TreeSet<Integer> prevDryDays = new TreeSet<Integer>();
        Map<Integer, Integer> lakeToPrevFullDays = new HashMap<>();
        for (int day = 0; day < rains.length; day++) {
            int lake = rains[day];
            // if it is a dry day
            if (lake == 0) prevDryDays.add(day);
            else {
                res[day] = -1;
                // if this lake is already full
                if (lakeToPrevFullDays.containsKey(lake)) {
                    int prevRainDay = lakeToPrevFullDays.get(lake);
                    Integer dryDay = prevDryDays.ceiling(prevRainDay);
                    if (dryDay == null) return new int[0];
                    res[dryDay] = lake;
                    prevDryDays.remove(dryDay);
                }
                lakeToPrevFullDays.put(lake, day);
            }
        }
        return res;
    }
}
