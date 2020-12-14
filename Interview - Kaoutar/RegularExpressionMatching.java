//https://leetcode.com/problems/regular-expression-matching/

class RegularExpressionMatching {
  static boolean isMatch(String text, String pattern) {
    
    return dp(text, pattern, text.length()-1, pattern.length()-1);
  }
  
  static boolean dp(String text, String pattern, int pText, int pPattern) {
    if(pText < 0 && pPattern < 0) return true;  // the end 
    
    int toSkip = 0;
    boolean result = false;
    if(pPattern >= 0 && pattern.charAt(pPattern) == '*') {        // s = "", p = "p*"
      result = dp(text, pattern, pText, pPattern-2); // skip ==> s = "ab", p = "abc*"

      while(!result && pText-toSkip >= 0 && 
            (text.charAt(pText-toSkip) == pattern.charAt(pPattern-1) || pattern.charAt(pPattern-1) == '.')) {
          //s = "abbbbbbc", p = "ab*c"  
          //s = "ppakjnnksxs"  p = ".*" (compare until it's not correct)
        result = result || dp(text, pattern, pText-toSkip, pPattern-1) ;
        toSkip++;
      }
      return result;
    }

    if(pText < 0 || pPattern < 0) return false; // one reach the end before the other

    if(text.charAt(pText) == pattern.charAt(pPattern) || pattern.charAt(pPattern) == '.') // s= "aa" p="aa" or s= "aa" p="a."
    {
        return dp(text, pattern, pText-1, pPattern-1);
    } else {
        return false;
    }
  } 
}
