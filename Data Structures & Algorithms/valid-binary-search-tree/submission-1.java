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
    public boolean isValidBST(TreeNode root) {
        // Use helper function to validate with range boundaries;
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean validate(TreeNode root, Integer min, Integer max) {
        // base case: root == null ,means pass validate
        if (root == null) {
            return true;
        }
        
        // if the root is not in the range return false
        if( max <= root.val ||root.val <= min) {
            return false;
        }
    
        // validate next right and left node and return result 
        // (node in right subtree must be bigger than root and smaller tham max 
        // && node in left subtree must be smaller than root and bigger than min)
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
