//https://leetcode.com/problems/find-root-of-n-ary-tree/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class FindRootN_aryTree {
    public Node findRoot(List<Node> tree) {
        Set<Integer> allChildren = new HashSet<>();
        
        for(Node node : tree) {
            if(node != null && !node.children.isEmpty()) {
                for(Node n : node.children) {
                    allChildren.add(n.val);
                }
            }
        }
        
        
        for(Node node: tree) {
            if(!allChildren.contains(node.val)) return node;
        }
        return null;
    }        
}
