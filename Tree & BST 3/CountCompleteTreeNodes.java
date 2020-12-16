//https://leetcode.com/problems/count-complete-tree-nodes/

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
 *
class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int sumLeft = 1;
        int sumRight = 1;
        TreeNode nodeLeft = root;
        TreeNode nodeRight = root;
        int result = 0;
        while(nodeLeft.left!= null) {
            sumLeft++;
            nodeLeft = nodeLeft.left;
        }
         while(nodeRight.right!= null) {
            sumRight++;
            nodeRight = nodeRight.right;
        }
        System.out.println(sumLeft);
        System.out.println(sumRight);
        
        for(int i = 0; i < sumLeft; i++) {
            result = result + (int)(Math.pow(2,i));
        }
        return (Math.abs(sumRight - sumLeft) > 0.0) ?  result - 1: result ;
        
    }
}*/

 class Solution {

     int toMinus = 0;
     boolean endComplete = false;
     
  public int countNodes(TreeNode root) {
      if(root == null) return 0;

     int countLevels = 0;
     TreeNode node = root;
     int result = 0;
      
     while(node.left != null) {
         countLevels++;
         node = node.left;
     }
     for(int i = 0; i <= countLevels; i++) {
          result += Math.pow(2,i);
     }
      
     countToSubstruct(root, countLevels+1, 0);
      
     return result - toMinus;
  }
     
    public void countToSubstruct(TreeNode root, int maxLevel, int depth) {
        if(root == null || endComplete) {
            if(depth >= maxLevel) endComplete = true;
            else if(!endComplete) toMinus++;
            return;
        }

        countToSubstruct(root.right, maxLevel, 1 + depth);
        countToSubstruct(root.left, maxLevel, 1 + depth);
    } 
     
     
     
}
