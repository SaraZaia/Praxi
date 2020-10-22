//https://leetcode.com/problems/implement-strstr/

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.length() == 0) return 0;
        int pointerN = 0;
        int pointerH = 0;
        
        while(pointerH <= haystack.length() - needle.length()) {
            while(pointerH <= haystack.length() - needle.length() && haystack.charAt(pointerH) != needle.charAt(pointerN)){
                pointerH++;
            }

            if( pointerH+needle.length() <= haystack.length() && needle.equals(haystack.substring(pointerH, pointerH+needle.length())))
                return pointerH;
            else {
                pointerN = 0;
                pointerH++;
            }
        }
        return -1;
    }
}
