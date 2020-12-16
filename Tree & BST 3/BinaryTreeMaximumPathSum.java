//https://leetcode.com/problems/binary-tree-maximum-path-sum/


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
class BinaryTreeMaximumPathSum {
    
    int resultMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int sol = pathSum(root);
        return Math.max(resultMax, sol);
    }
        
        
    public int pathSum(TreeNode root) {
        if(root != null && root.right == null && root.left == null) return root.val;
             
        int left = 0;
        int right = 0;
        int result;
        
        if(root.right == null) {
            left = pathSum(root.left);
             result = Math.max(root.val, root.val + left);
            resultMax = Math.max(resultMax, left);

        }
        else if(root.left == null) {
            right = pathSum(root.right);
            result = Math.max(root.val, root.val + right);
            resultMax = Math.max(resultMax, right);
        }
        else {
            left = pathSum(root.left);
            right = pathSum(root.right);
            result = Math.max(root.val, 
                              Math.max(root.val + left, root.val + right));
            resultMax = Math.max(resultMax, 
                                 Math.max(result, 
                                          Math.max(root.val + right +left, 
                                                   Math.max(left, right))));
        }
        
        resultMax = Math.max(resultMax, result);
        return result;        
    }
    
}
