//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


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
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> searchRoot = new HashMap<>();// root, index
    int pRootPreorder = 0;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i < inorder.length; i++) 
            searchRoot.put(inorder[i], i);
        System.out.println(searchRoot.toString());
        return buildTree(preorder, inorder, 0,inorder.length-1);
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int pStartInorder, int pEndInorder) {
        if(pStartInorder > pEndInorder || pRootPreorder >= preorder.length) return null;
        
        int indexRoot =  searchRoot.get(preorder[pRootPreorder]);
        pRootPreorder++;

        return new TreeNode(inorder[indexRoot] , 
                            buildTree(preorder, inorder, pStartInorder,indexRoot-1),
                           buildTree(preorder, inorder, indexRoot+1, pEndInorder));   
    }
}
