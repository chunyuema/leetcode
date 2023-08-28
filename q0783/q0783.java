class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < values.size()-1; i++){
            res = Math.min(res, values.get(i+1)-values.get(i));
        }
        return res;
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> values){
        if (root == null) return;
        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
    }
}