//https://practice.geeksforgeeks.org/problems/minimum-swaps/1


class MinimumSwapSortArray {
    // return the minimum number of swaps required to sort the array 
    public int minSwaps(int[] arr, int N) {
        Map<Integer, Integer> sortedArrWithIndex = new HashMap<>();
        Set<Integer> visited = new HashSet<>(); 
        
        int result = 0;
        int numCercle = 0;
        
        int i = 0;
        for(int x: arr) sortedArrWithIndex.put(x,i++);
        Arrays.sort(arr);
 
        int temp;
        
        for(int key: sortedArrWithIndex.keySet()) {
            numCercle = 0;
            temp = key;
            while(!visited.contains(temp)) {
                numCercle++;
                visited.add(temp);
                temp = arr[sortedArrWithIndex.get(temp)];
            }
            if(numCercle != 0) result += numCercle-1;
        }
        return result;
	}
}
