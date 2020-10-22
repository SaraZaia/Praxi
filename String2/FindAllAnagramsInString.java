//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;

        int window = p.length();
        int[] countChraP = new int[26];
        int[] countChraWindow = new int[26];
        for(char c: p.toCharArray()) countChraP[getIndex(c)] = countChraP[getIndex(c)]  + 1;
        for(int i = 0; i < window; i++) countChraWindow[getIndex(s.charAt(i))] = countChraWindow[getIndex(s.charAt(i))]+ 1;
        
        if(Arrays.equals(countChraP,countChraWindow)) result.add(0);
        
        for(int i = 1; i <= s.length()-window; i++) {
            countChraWindow[getIndex(s.charAt(i+window-1))] = countChraWindow[getIndex(s.charAt(i+window-1))]+ 1;
            countChraWindow[getIndex(s.charAt(i-1))] = countChraWindow[getIndex(s.charAt(i-1))]- 1;
            if(Arrays.equals(countChraP, countChraWindow)) result.add(i);

        }
        return result;
    }
    
    
    static int getIndex(char c) {
        return (int) c - 'a';
    }
}
