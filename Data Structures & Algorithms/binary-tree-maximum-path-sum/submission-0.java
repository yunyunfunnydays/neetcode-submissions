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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateGain(root);
        return maxSum;
    }

    private int calculateGain(TreeNode root){
        // use postOrder to get the sum of each subtree 

        // base case
        if (root == null){
            return 0;
        }

        // get the sum of each subtree 
        int leftSum = calculateGain(root.left);
        int rightSum = calculateGain(root.right);
        // if sum < 0 abandon 
        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
        
        // if sum of root and left and right subtree > maxSum -> renew maxSum
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
       
        // return larger sum of subtree 
        return Math.max(root.val + leftSum, root.val + rightSum);
    }



}
