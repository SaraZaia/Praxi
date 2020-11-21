//https://leetcode.com/problems/sort-characters-by-frequency/

class SortCharacterByFrequency {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        
        Map<Character, Integer> countChar = new HashMap<>();
        
        for(char c: s.toCharArray()) countChar.put(c, countChar.getOrDefault(c,0) + 1);
        List<Character> list = new ArrayList<>(countChar.keySet());
        
        Collections.sort(list, (Character c1, Character c2) -> countChar.get(c2) - countChar.get(c1));
        
        for(char c : list) {
            
            for(int i = 0; i < countChar.get(c); i++) result.append(c);
        }
        
        return result.toString();
        
        
    }
}
