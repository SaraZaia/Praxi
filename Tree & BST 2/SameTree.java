//https://leetcode.com/problems/same-tree/


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
class SameTree {
    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if(p == null && q==null) return true;
        if((p == null || q==null)) return false; // one is null the other no 
        if(p!= null && q!=null && (p.val != q.val)) return false; 
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        
        if(p != null && q != null && p.val == q.val) {
            pQueue.add(p);
            qQueue.add(q);
        } else if(p == null && q == null) return true;
        else return false;
        
        TreeNode qTemp;
        TreeNode pTemp;
        
        while(!pQueue.isEmpty() || !qQueue.isEmpty()) {
            
            pTemp = pQueue.poll();
            qTemp = qQueue.poll();
            
            if(pTemp.left != null && qTemp.left != null) {
                if(pTemp.left.val != qTemp.left.val) return false;
                pQueue.add(pTemp.left);
                qQueue.add(qTemp.left);
            } else if((pTemp.left != null && qTemp.left == null) || (pTemp.left == null && qTemp.left != null)) return false;

            if(pTemp.right != null && qTemp.right != null) {
                if(pTemp.right.val != qTemp.right.val) return false;
                pQueue.add(pTemp.right);
                qQueue.add(qTemp.right);
            } else if((pTemp.right != null && qTemp.right == null) || (pTemp.right == null && qTemp.right != null)) return false;
        }
        return true;
    }
}
