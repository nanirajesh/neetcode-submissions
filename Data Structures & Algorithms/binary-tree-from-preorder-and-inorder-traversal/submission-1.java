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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> indexes = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexes.put(inorder[i],i);
        }
        TreeNode root = util(preorder,inorder,indexes,0,preorder.length-1);
        return root;
    }

    private TreeNode util(int[] preorder,int[] inorder,Map<Integer,Integer> indexes,int min , int max) {
        if(min>max)
        return null;
        int val = preorder[index];
        TreeNode root = new TreeNode(val);
        index++;
        root.left = util(preorder,inorder,indexes , min , indexes.get(val)-1);
        root.right = util(preorder,inorder,indexes,indexes.get(val)+1,max);
        return root;
    } 
}
