//https://leetcode.com/problems/wildcard-matching/

class WildMatching {
    
    Map<String, Boolean> memo = new HashMap<>();
    public boolean isMatch(String s, String p) {
        return isMatchRec(s, p, s.length()-1, p.length()-1); 
    }
    
    public boolean isMatchRec(String s, String p, int pS, int pP) {
        if(memo.containsKey(pS + " - " + pP)) return memo.get(pS + " - " + pP);
        if(pP < 0 &&  pS <0) return true;
        else if((pP < 0 || pS <0) ) {
            if(pS < 0) {
                while(pP >=0) {
                    if(p.charAt(pP) != '*') return false;
                    pP--;
                }
                return true;
            }
            return false;
        }
        
        boolean result;
        if(s.charAt(pS) == p.charAt(pP) || p.charAt(pP) == '?') { 
            result = isMatchRec(s, p, pS-1, pP-1);
            memo.put(pS + " - " + pP, result);
            return result;
        }else if(p.charAt(pP) == '*') {
            result = isMatchRec(s, p, pS-1, pP) || isMatchRec(s, p, pS-1, pP-1) ||isMatchRec(s, p, pS, pP-1);  
            memo.put(pS + " - " + pP, result);
            return result;
        }
        return false;
    }
}
