//https://leetcode.com/problems/fruit-into-baskets/

class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int pStart = 0;
        int pEnd = 0;
        int countType = 0;
        int window = 2;
        Map<Integer, Integer> mapCount = new HashMap<>(); // <Type, Count occurence> 
        
        int resultMax = 0;
        
        int typeXvalue = 0;
        while(pEnd < tree.length) {
            
            if(countType <= window && pEnd < tree.length) {
                typeXvalue = mapCount.getOrDefault(tree[pEnd],0);
                mapCount.put(tree[pEnd], typeXvalue + 1);
                if(typeXvalue == 0) countType++;
                pEnd++;
            }
            else if(countType >= window) {
                typeXvalue = mapCount.getOrDefault(tree[pStart],0);
                mapCount.put(tree[pStart], typeXvalue - 1);
                if(typeXvalue == 1) countType--;
                pStart++;
            }
            if(countType <= window) {
                resultMax = Math.max(resultMax, pEnd - pStart);
                //System.out.println("Start = " + pStart + "  End = " + pEnd + "  count = " + countType);
            }
        }
        return resultMax;
    }
}


/*
Approach: Sliding Window

=> Found a window with the conditions having only 2 Types
    => if( a third type apear stop ) max = Math.max(max, pEnd - pStart +1 ) count = 2
    => remove until the count = 1 then add 
=> Return Max length window





*/
