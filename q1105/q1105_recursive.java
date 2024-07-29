class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        
        return dpHelper(books, 0, shelfWidth, memo);
    }

    private int dpHelper(final int[][] books, int i, final int shelfWidth, int[] memo) {
        // Base case: Already placed all books
        if (i == books.length) return 0;

        // Memoized Case: If already computed, return the memoized value
        if (memo[i] != Integer.MAX_VALUE) return memo[i];

        // Recursive Case: Try placing books starting from index i
        int currWidth = 0;
        int currMaxHeight = 0;
        int result = Integer.MAX_VALUE;
        for (int j = i; j < books.length; j++) {
            int bookWidth = books[j][0];
            int bookHeight = books[j][1];
            
            // Check if the book fits in the current shelf
            if (currWidth + bookWidth > shelfWidth) break;

            currWidth += bookWidth;
            currMaxHeight = Math.max(currMaxHeight, bookHeight);

            // Calculate the height if placing book j on the same shelf
            int height = currMaxHeight + dpHelper(books, j + 1, shelfWidth, memo);
            result = Math.min(result, height);
        }

        memo[i] = result;
        return result;
    }
}
