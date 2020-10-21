//https://leetcode.com/problems/group-anagrams/

class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr); 
            List<String> list = new ArrayList<>();
            list = anagrams.getOrDefault(str, list);
            list.add(s);
            anagrams.put(str , list);
        }

        return new ArrayList<>(anagrams.values());
    }
}
