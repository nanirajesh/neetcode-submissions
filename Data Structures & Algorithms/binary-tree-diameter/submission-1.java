/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        util(root);
        return max;
    }

    private int util(TreeNode root){
        if(root == null) return 0;
        int left= util(root.left);
        int right = util(root.right);
        int include = left+right;
        int dont=1+ Math.max(left,right);
        max= Math.max(max,include);
        return dont;
    }
}
