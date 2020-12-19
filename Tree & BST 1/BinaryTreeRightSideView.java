//https://leetcode.com/problems/binary-tree-right-side-view/


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
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        if(root != null) queue.add(new Pair(root,1));
        
        Pair temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            
            if(temp.level > result.size()) {
                result.add(temp.node.val);
            }
            
            if(temp.node.right != null) queue.add(new Pair(temp.node.right, temp.level+1 ));
            if(temp.node.left != null) queue.add(new Pair(temp.node.left, temp.level+1 ));
        }
        return result;
    }
    
    
    static class Pair{
        TreeNode node;
        int level;
        
        Pair(TreeNode n, int l) {
            node = n;
            level = l;
        }
    }
}
