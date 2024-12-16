class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        while (extraStudents > 0) {
            // Assign student
            extraStudents--;

            // Assign to the class which yield largests gain
            double[] curr = maxHeap.poll();
            int passes = (int) curr[1];
            int totalStudents = (int) curr[2];

            // Add the updated class back to the pq
            double newGain = calculateGain(passes + 1, totalStudents + 1);
            maxHeap.offer(new double[] {newGain, passes + 1, totalStudents + 1});
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
            (double) (passes + 1) / (totalStudents + 1) -
            (double) passes / totalStudents
        );
    }
}
