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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return ;
        }
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
        return constructTree(queue);
    }
    private TreeNode constructTree(Queue<String> queue) {
        String s = queue.remove();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = constructTree(queue);
        root.right = constructTree(queue);
        return root;
    }

}
