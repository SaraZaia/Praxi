//https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
class MaximumDepthOfBinaryTree {
    int result = 0;
    
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    
    
    public void dfs(TreeNode node, int depth) {
        if(node == null) {
            result = Math.max(result, depth);
            return ;
        }
        
        dfs(node.right, 1 + depth);
        dfs(node.left, 1 + depth);
        
    }
}
