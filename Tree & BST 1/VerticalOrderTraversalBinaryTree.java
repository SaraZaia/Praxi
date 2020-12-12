//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

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
class  VerticalOrderTraversalBinaryTree {
    Map<Integer, PriorityQueue<Pair>> vLevels = new TreeMap<>();// TreeMap for the Vertical order -1 0 1
    //Priority queue for order: If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        dfsVertivalLevel(root, 0, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res;
        Pair tempPair;
        for(PriorityQueue<Pair> qp : vLevels.values()) {
            res = new ArrayList<>();
            while(!qp.isEmpty()) {
                tempPair = qp.poll();
                res.add(tempPair.getPairValue());
            }
            result.add(res);
        }
        
        return result;
    }
    
    
    public void dfsVertivalLevel(TreeNode root, int level, int row) {
        if(root == null) return;
        
        PriorityQueue<Pair> pQueue = vLevels.getOrDefault(level, new PriorityQueue<>( new Comparator<Pair>() {
                                        public int compare(Pair o2, Pair o1) {
                                            return o2.row - o1.row != 0?  o2.row - o1.row: o2.value - o1.value;
                                        }
                                    }
                                   ));
        
        pQueue.add(new Pair(row,root.val));
        vLevels.put(level, pQueue);
        
        dfsVertivalLevel(root.left, level-1, row+1);
        dfsVertivalLevel(root.right, level+1, row+1);

    }

    static class Pair {
        int row;
        int value;
        
        Pair(int r, int v) {
            row = r;
            value = v;
        }
        
        int getPairValue() {
            return value;
        }
    }
}
