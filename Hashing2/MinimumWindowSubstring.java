//https://leetcode.com/problems/minimum-window-substring/

/* Time limit exeeded
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
    
}*/



class MinimumWindowSubstring {
        
    
    // 0- Create a Map with t letter = 1
    // 0- Create a Map with t letter for S
    // 1- Two Pointer pStart and pEnd 
    // 2- if( maps  s >= t )  count comapre MapT with MapS
    // 2- find a first solution
    // 3- improve it 
    // 4- find other solution
    
    public String minWindow(String s, String t) {
        //Target Letters
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();

        for(char c: t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c,0)+1);
            mapS.put(c,0);
        }

        //Solutions Letter
        int pStart = 0;
        int pEnd = 0;
        int count = 0;          // if Add : mapS.get(c) < mapT.get(c) count--  
        int target = t.length(); // if Delete : mapS.get(c) == mapT.get(c) count++
        
        //Result : min length
        int pStartRes = 0;
        int pEndRes = 0;
        
        char currChar = '-';
        while(pStart < s.length() && pEnd < s.length()) {
            
            while(count < target && pStart < s.length() && pEnd < s.length()) { //Add Characters
                currChar = s.charAt(pEnd); 
                if(mapT.containsKey(currChar)) {
                    if(mapT.get(currChar) > mapS.get(currChar)) count++;
                    
                    mapS.put(currChar, mapS.getOrDefault(currChar,0)+1);
                }
                
                pEnd++;
                //System.out.println(count+" +++++++ " + s.substring(pStart, pEnd));
            }

            if(count == target && (pEndRes == 0 || pEndRes - pStartRes >= pEnd - pStart)) {
                pStartRes = pStart;
                pEndRes = pEnd; 
            }
            //System.out.println(s.substring(pStartRes, pEndRes));

            while(count == target && pStart < pEnd) {
                currChar = s.charAt(pStart);
                if(mapT.containsKey(currChar) && mapT.get(currChar) >= mapS.get(currChar)) {
                    count--;
                    mapS.put(currChar, mapS.getOrDefault(currChar,0)-1);
                }
                else if(mapT.containsKey(currChar) && mapT.get(currChar) < mapS.get(currChar)){
                    mapS.put(currChar, mapS.getOrDefault(currChar,0)-1);
                }
                pStart++;
                if(count == target && (pEndRes == 0 || pEndRes - pStartRes >= pEnd - pStart)) {
                    pStartRes = pStart;
                    pEndRes = pEnd; 
                }
                //System.out.println(count+" ---- " + s.substring(pStart, pEnd));
            } 

        }
        return s.substring(pStartRes, pEndRes);
    }

}
