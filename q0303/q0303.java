class NumArray {

    private List<Integer> prefixSum = new ArrayList<>();

    public NumArray(int[] nums) {
        prefixSum.add(0);
        for (int num : nums) {
            prefixSum.add(num + prefixSum.get(prefixSum.size()-1));
        } 
    }
    
    public int sumRange(int left, int right) {
        return prefixSum.get(right+1) - prefixSum.get(left);
    }
}