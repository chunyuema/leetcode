class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) return pascal; 
        pascal.add(new ArrayList<>(List.of(1)));
        if (numRows == 1) return pascal;

        List<Integer> lastRow = pascal.get(0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
                newRow.add(lastRow.get(j) + lastRow.get(j+1));
            }
            newRow.add(1);
            pascal.add(newRow);
            lastRow = newRow;
        }
        return pascal;
    }
}