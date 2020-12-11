//https://leetcode.com/problems/binary-tree-level-order-traversal/

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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queueBFS = new LinkedList<>();
        int countLevel = 1;
        int previousLevel = 0;
        if(root != null) queueBFS.add(root); // Addding root
        TreeNode node;
        while(!queueBFS.isEmpty()) {  //(9) (20)
            List<Integer> subList = new ArrayList<>();
            previousLevel = countLevel;  // 2
            countLevel = 0;

            while(previousLevel  > 0) {
                node = queueBFS.poll(); //  (9)
                subList.add(node.val); // {9} 
                if(node.left != null) {
                    queueBFS.add(node.left); // (20) 
                    countLevel++;
                }
                if(node.right != null) {
                    queueBFS.add(node.right); // (20)
                    countLevel++;
                }
                previousLevel--;  // 1
            }
            result.add(subList);
        }   // { {3}}
    return result;
    }
}
