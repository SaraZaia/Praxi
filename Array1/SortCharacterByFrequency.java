//https://leetcode.com/problems/sort-characters-by-frequency/

class SortCharacterByFrequency {
    public String frequencySort(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)+"")) map.put(s.charAt(i)+"", 1);
            else map.compute(s.charAt(i)+"", (k,v) -> v+1);
        }

        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, (a,b) ->map.get(b)-map.get(a));
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < list.size(); i++) {
            for(int k = 0; k < map.get(list.get(i)); k++)
                result.append(list.get(i));
        }


        return result.toString();
    }
}
