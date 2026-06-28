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
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return root;
        }

        // recursive
        invertTree(root.left);
        invertTree(root.right);

        // invert node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // TreeNode left = invertTree(root.left);
        // TreeNode right = invertTree(root.right);
        // root.left = right; // 直接拿回傳結果來接
        // root.right = left;




        return root;
        
    }
}
