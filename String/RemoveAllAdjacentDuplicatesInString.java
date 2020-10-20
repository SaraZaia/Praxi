//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
// Note : a better solution is STACK 
//for example: leelcode
// lee
// ll
// code
class Solution {
    public String removeDuplicates(String S) {
        
        if(S.length() <= 1) return S;
        StringBuilder result = new StringBuilder();
        int i = 0;
        for(i = 0; i < S.length() - 1; i++) {
            if(S.charAt(i) != S.charAt(i+1)){
                result.append(S.charAt(i));
            } else {
                i++;
            }
                
        }
        if( i != S.length())
            result.append(S.charAt(S.length()-1));

        System.out.println(result.toString());
        if(result.length() == S.length()) return S;
        return removeDuplicates(result.toString());
    }
}
