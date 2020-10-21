//https://leetcode.com/problems/longest-palindromic-substring/

class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int pStart = 0;
        int pEnd = s.length() - 1;
        
        String result = s.charAt(0)+"";
        outer:for(int i = 0; i < s.length(); i++) {
            pStart = i;
            pEnd = s.length() - 1;
            while(pStart <= pEnd) {
                if(pStart < pEnd && (s.charAt(pStart) != s.charAt(pEnd) || !isAnagram(s, pStart,pEnd))) {
                    pEnd--;
                }
                else {

                    if(pEnd-pStart+1 > result.length()) result = s.substring(pStart, pEnd+1);

                    continue outer;
                }
            }
        }
        return result;
        
    }
    
    
    public boolean isAnagram(String s, int pStart, int pEnd) {
        while(pStart <= pEnd) {
            if(s.charAt(pStart) == s.charAt(pEnd)) {
                pStart++;
                pEnd--;
            } else return false;
        }
        return true;
    }
}
