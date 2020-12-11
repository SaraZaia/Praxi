//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


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
class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int mid = nums.length / 2;
        return new TreeNode(nums[mid], inorderSearch(nums, 0, mid-1),inorderSearch(nums, mid+1, nums.length-1));
    }

    TreeNode inorderSearch(int[] nums, int pStart, int pEnd) {
        int mid = pStart + (pEnd - pStart) /2;
        if(pEnd - pStart < 0) return null;
        else 
            return new TreeNode(nums[mid], inorderSearch(nums, pStart, mid-1),inorderSearch(nums, mid+1, pEnd));        
    }
    
}
