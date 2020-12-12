//https://leetcode.com/problems/validate-binary-search-tree/


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
class ValidateBinarySearchTree {
    List<Integer> inorderList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        inorderTravesal(root);
        System.out.println(inorderList);
        for(int i = 0; i < inorderList.size()-1 ; i++) {
            if(inorderList.get(i) >= inorderList.get(i+1)) return false;
        }
        return true;
        
    }
    
    public void inorderTravesal(TreeNode root) {
        if(root.left != null) inorderTravesal(root.left);
        inorderList.add(root.val);
        if(root.right != null) inorderTravesal(root.right);
    }
    
}
