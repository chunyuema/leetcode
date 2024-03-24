class FrequencyTracker {
    private int[] numFreq;
    private int[] freqCount;

    public FrequencyTracker() {
        numFreq = new int[100001];
        freqCount = new int[100001];
    }

    public void add(int number) {
        int prevFreq = numFreq[number];

        // Update the frequency of numbers
        numFreq[number]++;

        // Update the count of the frequencies
        freqCount[prevFreq]--;
        freqCount[prevFreq + 1]++;
    }

    public void deleteOne(int number) {
        int prevFreq = numFreq[number];
        if (prevFreq > 0) {
            // Update the frequency of numbers
            numFreq[number]--;

            // Update the count of the frequencies
            freqCount[prevFreq]--;
            freqCount[prevFreq - 1]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqCount[frequency] >= 1;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */