class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                // If they are the same height, sort based on how many people there are before them in the queue
                return p1[1] - p2[1];
            } else {
                // If they are not the same height, the taller person gets sorted to the front.
                return p2[0] - p1[0];
            }
        });


        // Use linked list for quick insertion
        List<int[]> res = new LinkedList<>();

        // Note that we will be processing taller people first
        for (int[] currPerson : people) {
            // insert current person at the place based on how many people are taller than the current person
            // directly inserting at res[currPerson[1]] is fine, as we have already processed the people taller than the current person.
            // hence adding the currPerson at currPerson[i] will not change the number of people taller than the previously arranged taller people
            res.add(currPerson[1], currPerson);
        }

        return res.toArray(new int[people.length][2]);
    }
}