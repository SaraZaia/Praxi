//https://leetcode.com/problems/generate-parentheses/

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        generateParenthesisRec(n, n, result, list);
        
        return list;
    }
    
    public void generateParenthesisRec( int  nOpen, int nClose , StringBuilder result, List<String> list) {
        
        if(nOpen == 0 && nClose == 0) {
            list.add(result.toString());
            return;
        }
        
        if(nOpen > 0) {
            result.append("(");
            generateParenthesisRec(nOpen - 1, nClose, result, list);
            result.deleteCharAt(result.length() - 1);
        }
        
        if(nClose > 0 && nClose > nOpen) {
            result.append(")");
            generateParenthesisRec(nOpen, nClose - 1, result, list);
            result.deleteCharAt(result.length() - 1);
        }
        
    }
    
    
}
