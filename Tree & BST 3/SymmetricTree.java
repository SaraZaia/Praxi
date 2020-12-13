//https://leetcode.com/problems/symmetric-tree/

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
 
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null ) return true;
        return areSymmetric(root.left, root.right);
    }
    
    
    public boolean areSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if((left != null && right == null) || (left == null && right != null)) return false;
        if((left != null && right != null) && left.val != right.val) return false;
        else return (areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left));
    }
    
}
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left== null && root.right == null)) return true;
        if(root.left!= null && root.right != null && root.left.val == root.right.val )
            return areSymetric(root.left, root.right);
        else return false;
    }
    
    
	static public boolean areSymetric(TreeNode left, TreeNode right) {
        Queue<TreeNode> rightTree = new LinkedList<>();
        Queue<TreeNode> leftTree = new LinkedList<>();
        
        if(left.val == right.val) {
            rightTree.add(right);
            leftTree.add(left);
        } else return false;
        
        TreeNode tempRight;
        TreeNode tempLeft;
        
        while(!rightTree.isEmpty() && !leftTree.isEmpty()) {
            tempLeft = leftTree.poll();
            tempRight = rightTree.poll();
            if(tempLeft.right != null && tempRight.left != null) {
                if(tempRight.left.val == tempLeft.right.val) {
                    rightTree.add(tempRight.left);
                    leftTree.add(tempLeft.right);
                } else return false;
            }
            else if(tempLeft.right != null || tempRight.left != null)
                return false;
            
            if(tempLeft.left != null && tempRight.right != null) {
                if(tempRight.right.val == tempLeft.left.val) {
                    rightTree.add(tempRight.right);
                    leftTree.add(tempLeft.left);
                } else return false;
            }
            else if(tempLeft.left != null || tempRight.right != null)
                return false;
        }
        
        return rightTree.isEmpty() && leftTree.isEmpty() ? true : false;
	}
    
}
