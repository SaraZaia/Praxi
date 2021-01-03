//https://leetcode.com/problems/invert-binary-tree/

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
class InvertBinaryTree {
    
    // Recursive approach
    public TreeNode invertTree(TreeNode root) {   
        if(root == null) return null;
        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }
    
    // Iterative approach
    public TreeNode invertTree(TreeNode root) {   
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        TreeNode temp;
        TreeNode curr;
        
        while(!queue.isEmpty()) {
            curr = queue.poll();
            
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.right != null) queue.add(curr.right);
            if(curr.left != null) queue.add(curr.left);
        }
        return root;
    }
}
