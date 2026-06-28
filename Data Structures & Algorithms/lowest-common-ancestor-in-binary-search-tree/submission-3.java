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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (p.val < root.val && root.val < q.val || (q.val < root.val && root.val < p.val ) || p.val == root.val || q.val == root.val) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val ) {
                root = root.right;
            }
        }
        return null;
    }
}
