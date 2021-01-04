//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class MaximumDepthOfNaryTree {
    int result = 0;
    public int maxDepth(Node root) {
        maxDepth(root, 0);
        return result;
    }
    
    public void maxDepth(Node root, int depth) {
        if(root == null ) return; 
        
        if(root.children == null || root.children.size() == 0) {
            result = Math.max(depth+1, result);
            return;
        }

        for(Node node: root.children)
            maxDepth(node, 1 + depth);
    }
}
