//https://leetcode.com/problems/cousins-in-binary-tree/

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
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        int depthResult = -1;
        
        Pair temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.node.val == x || temp.node.val == y) {
                if(depthResult == -1) depthResult = temp.depth;
                else if(depthResult == temp.depth) return true;
            }
            
            if(temp.node.right != null && temp.node.left != null) {
                if((temp.node.left.val == x && temp.node.right.val == y) 
                   || (temp.node.left.val == y && temp.node.right.val == x))
                    return false;
            }
            if(temp.node.right != null) queue.add(new Pair(temp.node.right, temp.depth+1));
            if(temp.node.left != null) queue.add(new Pair(temp.node.left, temp.depth+1));
        }
        return false;
    }
    
    
    
    static class Pair {
        TreeNode node;
        int depth;
        
        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}
