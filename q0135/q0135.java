class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // ensures that all children with higher ratings get more candies than their
        // left neighbor
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // ensures that all children with higher ratings get more candies than their
        // right neighbor
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1] && candies[j + 1] + 1 > candies[j]) {
                candies[j] = candies[j + 1] + 1;
            }
        }

        int totalCandy = 0;
        for (int c : candies)
            totalCandy += c;
        return totalCandy;
    }
}