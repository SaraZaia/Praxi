//https://leetcode.com/problems/relative-sort-array/

class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> countRest = new TreeMap<>();
        
        for(int x: arr1) count.put(x, count.getOrDefault(x,0) + 1);
        
        int i = 0;
        int c = 0;
        for(int x : arr2) {
            c = count.get(x);
            while(c > 0){
               arr1[i++] = x; 
                c--;
            }
            count.remove(x);
        }
        countRest.putAll(count);
        
        for(int x : countRest.keySet()) {
            c = countRest.get(x);
            while(c > 0){
               arr1[i++] = x; 
                c--;
            }
        }

        
        return arr1;
    }
}
