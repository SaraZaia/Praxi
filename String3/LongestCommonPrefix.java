//https://leetcode.com/problems/longest-common-prefix/

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        if(count == 0) return "";
        int[] coutLetter = new int[strs[0].length()];
        int i;
        outer:for(String str: strs) {
            if(str.length() == 0 ) return "";
            i = 0;
            for(char c : str.toCharArray()) {
                if(strs[0].charAt(i) == str.charAt(i)) coutLetter[i] = coutLetter[i] + 1;
                else break;
                i++;
                if(i >= strs[0].length()) continue outer;

            }
        }
        
        StringBuilder result = new StringBuilder();
        int k = 0;
        for(char c : strs[0].toCharArray()){
            if(coutLetter[k] == count) {
                result.append(c);
            }
            else break;
            k++;
        }
        return result.toString();
    }
    
    
    public int getIndex(char c) {
        return (int)c - 'a';
    }
    
}
