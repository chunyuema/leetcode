class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> indexQueue = new LinkedList<>();

        // Add all the index to the queue
        for (int i = 0; i < n; i++)
            indexQueue.add(i);

        Arrays.sort(deck);

        int[] newDeck = new int[n];
        for (int i = 0; i < n; i++) {
            int card = deck[i];

            // The card will go to the index at the top of the queue
            int idx = indexQueue.poll();
            newDeck[idx] = card;

            // The next index will move to the tail of the queue
            indexQueue.add(indexQueue.poll());
        }
        return newDeck;
    }
}