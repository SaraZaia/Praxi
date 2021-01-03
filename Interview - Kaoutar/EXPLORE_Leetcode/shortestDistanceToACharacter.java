//https://leetcode.com/problems/shortest-distance-to-a-character/

class shortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int[] suffixIndex = new int[S.length()];
        int previousSuffix = Integer.MAX_VALUE;
        //int[] prefixIndex = new int[S.length()];
        int previousPrefix = Integer.MAX_VALUE;
        
        int[] result = new int[S.length()];
        
        
        int j = S.length()-1;
        for(int i = S.length()-1; i >=0; i--) {
            if(S.charAt(i) == C)
                previousSuffix = i;            
            //if(S.charAt(j-i) == C)
              //  previousPrefix = j-i;
            
            suffixIndex[i] = previousSuffix;
            //prefixIndex[j-i] = previousPrefix;
        }
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C)
                previousPrefix = i;
            result[i] = Math.min(Math.abs(previousPrefix - i), Math.abs(suffixIndex[i] - i));
        }
        return result;
    }
}
