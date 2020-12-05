//https://leetcode.com/problems/minimum-window-substring/

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
