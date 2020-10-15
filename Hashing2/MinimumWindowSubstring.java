//https://leetcode.com/problems/minimum-window-substring/

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> sHash = new HashMap<>();
        Map<Character, Integer> tHash = new HashMap<>();

        for(char c : t.toCharArray()) tHash.put(c, tHash.getOrDefault(c,0)+1);

        String solution = "";        
        int pStart = 0;
        int pEnd = 0;
        if(pStart < s.length() ) 
            sHash.put(s.charAt(pEnd), sHash.getOrDefault(s.charAt(pEnd),0)+1);

        while( pStart <= pEnd) {
            if(s.length()-pStart < t.length()) break;
            while(pEnd < s.length() && !containAllChar(s, pStart, pEnd,t, sHash, tHash)) {
                if(pEnd+1 < s.length()) {
                    pEnd++;
                    sHash.put(s.charAt(pEnd), sHash.getOrDefault(s.charAt(pEnd),0)+1);
                }
                else break;
            }
            System.out.println(s.substring(pStart, pEnd+1));
            do{
                if(containAllChar(s, pStart, pEnd,t, sHash, tHash))
                    solution = solution.length() <= pEnd-pStart+1 && solution != "" ? solution : 
                    s.substring(pStart, pEnd+1);

                sHash.put(s.charAt(pStart), sHash.getOrDefault(s.charAt(pStart),0)-1);
                pStart++;
                
            } while(pStart <= pEnd && containAllChar(s, pStart, pEnd, t, sHash, tHash));

            if(pStart < pEnd ) 
                sHash.put(s.charAt(pStart), sHash.getOrDefault(s.charAt(pStart),0)-1);
            pStart++;

        }
        
        return solution;
    }
    
    
    public static boolean containAllChar(String s, int pStart, int pEnd, String t, Map<Character, Integer> sHash, Map<Character, Integer> tHash) {
        for(int i = 0; i < t.length(); i++) {  
            if(!sHash.containsKey(t.charAt(i)) || sHash.get(t.charAt(i)) < tHash.get(t.charAt(i))) return false;
        }
        return true;
    }
    
}
