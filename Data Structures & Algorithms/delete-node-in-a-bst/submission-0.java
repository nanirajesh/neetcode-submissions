
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: No left child
            if (root.left == null) return root.right;

            // Case 2: No right child
            if (root.right == null) return root.left;

            // Case 3: Two children
            TreeNode curr = root.right;

            while (curr.left != null) {
                curr = curr.left;
            }

            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }

        return root;
    }
}
