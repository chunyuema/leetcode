class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            // if there is no left subtree
            if (root.left == null) return root.right;

            // if there is no right subtree
            if (root.right == null) return root.left;

            // if there are both left and right subtree
            TreeNode inOrderSuccessorNode = findInOrderSuccessor(root.right);
            // swap the root val with the in order successor val
            int temp = root.val;
            root.val = inOrderSuccessorNode.val; 
            inOrderSuccessorNode.val = temp;
            root.right = deleteNode(root.right, temp);
        }
        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left; 
        }
        return node;
    }
}