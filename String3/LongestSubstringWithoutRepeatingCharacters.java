//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxWindow = 0;
        int maxCharCount = 1;
        Map<Character, Integer> map = new HashMap<>(); 
        
        int i = 0;
        int k = 0;
        
        while( i < s.length()) {
            maxCharCount--;
            if( i > 0) map.put(s.charAt(i-1), map.getOrDefault(s.charAt(i-1),0)-1);

            while( k < s.length()) {
                if(map.getOrDefault(s.charAt(k),0) >= 1) break;
                map.put(s.charAt(k), map.getOrDefault(s.charAt(k),0)+1);
                maxCharCount++;
                k++;
            }
            maxWindow = maxWindow < maxCharCount? maxCharCount: maxWindow;
            i++;
        }
        
        return maxWindow;
    }
}
