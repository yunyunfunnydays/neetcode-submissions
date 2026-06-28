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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            
            //  move to deepest left node and put record node into stack
            while (root != null){
                stack.push(root);
                root = root.left; 
            }

            // pop node from stack
            // decrement k 
            // check if k == 0 return result
            root = stack.pop();
            k--;
            if (k == 0) return root.val;

            // move to right child node
            root = root.right;
        }
        // Default return (should not be reached)
        return -1;
    }

}
