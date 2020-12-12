//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val) ) 
            return root;
        else if(root.val <  p.val && root.val < q.val) 
            return lowestCommonAncestor(root.right, p,q);
        else 
            return lowestCommonAncestor(root.left, p,q);
    }
}
