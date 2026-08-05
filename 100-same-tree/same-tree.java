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
    
        public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both nodes are null
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One node is null or values don't match
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursive Step: Check left subtrees and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}