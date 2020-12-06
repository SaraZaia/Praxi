//https://leetcode.com/problems/isomorphic-strings/

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> letterS = new HashMap<>();
        Map<Character, Character> letterT = new HashMap<>();
        
        if(t.length() != s.length()) return false;
        for(int i = 0; i < t.length(); i++) {
            if(!letterS.containsKey(s.charAt(i))) letterS.put(s.charAt(i), t.charAt(i));
            if(!letterT.containsKey(t.charAt(i))) letterT.put(t.charAt(i), s.charAt(i));
            
            if((letterS.containsKey(s.charAt(i)) && t.charAt(i) != letterS.get(s.charAt(i)) )
               || (letterT.containsKey(t.charAt(i)) && s.charAt(i) != letterT.get(t.charAt(i)))) 
                return false;
        }
        return true;
    }
}
