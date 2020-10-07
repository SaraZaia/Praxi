class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arrOne = new HashMap<Integer, Integer>();
        for(int x: arr1) {
            if(arrOne.containsKey(x)) arrOne.compute(x, (k,v)->v+1);
            else arrOne.put(x, 1);
        }
        
        int[] result = new int[arr1.length];
        int k = 0;
        for(int x : arr2) {
            for(int i = 0; i < arrOne.get(x); i++) {
                result[k++] = x;
            }
            arrOne.remove(x);
        }
        
        
        List<Integer> list = new ArrayList<>(arrOne.keySet());
        Collections.sort(list);
        for(int x : list) {
            for(int i = 0; i < arrOne.get(x); i++) {
                if(arrOne.containsKey(x)) result[k++] = x;
            }
        }
        
        return result;
    }
}
