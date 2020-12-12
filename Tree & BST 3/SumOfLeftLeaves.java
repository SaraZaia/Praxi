//https://leetcode.com/problems/sum-of-left-leaves/


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
class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList();
        TreeNode tempNode;
        if(root != null) queue.add(root);
        
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            
            if(tempNode.left != null && tempNode.left.left == null && tempNode.left.right == null )
                sum += tempNode.left.val;
            
            if(tempNode.left != null) queue.add(tempNode.left);
            if(tempNode.right != null) queue.add(tempNode.right); 
        }
        return sum;
        
    }
}
