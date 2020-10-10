//https://leetcode.com/problems/first-unique-character-in-a-string/

class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(map.containsKey(c)) map.compute(c, (k,v)->v+1);
            else map.put(c, 1);
        } 
        
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
