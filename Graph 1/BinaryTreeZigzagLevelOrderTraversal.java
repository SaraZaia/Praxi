//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level;
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        int currLevel = 0;
        int countLevel = 1;
        
        boolean isRight = false; 
        TreeNode node;
        
        while(queue.size() > 0) {
            currLevel = countLevel;
            countLevel = 0;
            level = new ArrayList<>();
            while(currLevel > 0) {
                node = queue.poll();            
                if(isRight) level.add(node.val);
                else level.add(0, node.val);
                
                if(node.right != null) {
                    queue.add(node.right);
                    countLevel++;
                }
                if(node.left != null) {
                    queue.add(node.left);
                    countLevel++;
                }
                currLevel--;
            }  
            isRight = !isRight;
            result.add(level);
        }
        return result;
    }
}
