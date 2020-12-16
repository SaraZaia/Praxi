//https://leetcode.com/problems/balanced-binary-tree/


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
class BalancedBinaryTree {
    
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        
        dfs(root);
        return result;
    }
    
    
    public int dfs(TreeNode root) {
        if(root == null || !result) return 0;
        
        int right = dfs(root.right);
        int left = dfs(root.left);
        
        if(Math.abs(right-left) > 1) result = false;
        
        return 1 + Math.max(right, left);
        
    }

}
