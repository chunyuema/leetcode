class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        // Create the newDeck for the final result
        int[] newDeck = new int[n];
        Arrays.fill(newDeck, -1);

        Arrays.sort(deck);

        int deckPointer = 0;
        int newDeckPointer = 0;
        boolean skip = false;

        // Try to find an index to fit every element from the sorted deck
        while (deckPointer < n) {

            // Only try to fill the newDeck if it has not been filled before
            if (newDeck[newDeckPointer] == 0) {
                // Try to copy the element over only if it is not skip
                // Skip == true indicates that during the simulation,
                // this card will be moved to the end of the queue
                if (!skip) {
                    newDeck[newDeckPointer] = deck[deckPointer];
                    deckPointer++;
                }

                // toggle skip to ensure that we are in the right state
                skip = !skip;
            }

            // Move to the next index
            // The index keeps cycling through the newDeck
            newDeckPointer = (newDeckPointer + 1) % n;
        }
        return newDeck;
    }
}