//

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
class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    Map<Integer, Integer> searchRoot = new HashMap<>();
    int postorderRoot;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderRoot = postorder.length-1;
        for(int i = 0; i < inorder.length; i++)
            searchRoot.put(inorder[i] ,i );
    
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int pStartInorder, int pEndInorder) {
        if(pStartInorder > pEndInorder || postorderRoot < 0) return null;
        int index = searchRoot.get(postorder[postorderRoot]);
        postorderRoot--;
        
        int val = inorder[index];
        TreeNode right = buildTree(inorder, postorder, index+1, pEndInorder);
        TreeNode left = buildTree(inorder, postorder, pStartInorder, index-1);
        
        
        return new TreeNode(val, left, right);
    }
    
}
