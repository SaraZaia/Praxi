//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int countLevel = 1;
        int previousLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        TreeNode tempNode;
        
        
        while(!queue.isEmpty()) {
            previousLevel =countLevel;
            countLevel = 0;
            level = new ArrayList<>();
            while(previousLevel > 0) {
                tempNode = queue.poll();
                level.add(0,tempNode.val);
                
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                    countLevel++;
                }
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                    countLevel++;
                }
                previousLevel--;
            }
            result.add(0, level);
        }
        return result;
    }
}
