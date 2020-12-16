//https://leetcode.com/problems/diameter-of-binary-tree/

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
class DiameterOfBinaryTree {
    
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int solution = 0;
        if(root != null) 
        solution = dfs(root.right) + dfs(root.left);
        return Math.max(result, solution);
    }
    
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        
        int right = dfs(root.right);
        int left = dfs(root.left);
        
        result = Math.max(result, right+left);
        
        return 1 + Math.max(right, left); // Count the edge that come before the node
    }
}
