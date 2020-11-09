//https://leetcode.com/problems/reorganize-string/


class ReorganizeString {
    
    public String reorganizeString(String S) {
       	StringBuilder result = new StringBuilder();
	    Map<Character, Integer> mapCount = new HashMap<>();
        PriorityQueue<Pair> pqPair = new PriorityQueue<>((Pair a, Pair b) -> b.count - a.count);

        for(char c: S.toCharArray()) mapCount.put(c, mapCount.getOrDefault(c,0) + 1);

        for(char c: mapCount.keySet())  {
            pqPair.add( new Pair(c, mapCount.get(c)));
        }
        

        Pair pairOne = null;
        Pair pairTwo = null;

        while(!pqPair.isEmpty()) {
            pairOne = pqPair.poll();
            if(result.length() != 0 && result.charAt(result.length()-1) == pairOne.value ) return "";
            result.append(pairOne.value);
            

            if(!pqPair.isEmpty()) {
                pairTwo = pqPair.poll();
                if(result.length() != 0 && result.charAt(result.length()-1) == pairTwo.value ) return "";
                result.append(pairTwo.value);

            }

            if(pairOne!=null && pairOne.count -1 > 0) pqPair.add( new Pair(pairOne.value, pairOne.count - 1));
            if(pairTwo!=null && pairTwo.count -1 > 0) pqPair.add( new Pair(pairTwo.value, pairTwo.count - 1));
            pairOne = null;
            pairTwo = null;
            

        }

        return result.toString();
    }

    class Pair{
	    char value;
        int count;
        Pair(char value, int count) {
	        this.value = value;
	        this.count = count;
        }
    }

}
