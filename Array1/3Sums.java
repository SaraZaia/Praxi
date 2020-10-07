class 3Sums {
/*    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result =  new HashSet<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int[] arr = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                b = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    c = nums[k];
                    if(a + b + c == 0){
                        arr[0] = a;
                        arr[1] = b;
                        arr[2] = c;
                        Arrays.sort(arr);
                        result.add(new ArrayList(Arrays.asList(arr[0], arr[1], arr[2])));
                        
                    }
                }    
            }
        }
        return new ArrayList<>(result);
        
    }*/
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start = 1;
        int end = nums.length - 1; 
        Set<List<Integer>> result =  new HashSet<>();

        
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < nums.length; i++) { // First pointer
            a = nums[i];
            start = i + 1; //Second Pointer
            end = nums.length - 1; // Third pointer
            while(start < end) {
                if(nums[start] + nums[end] + a < 0) start++;
                else if(nums[start] + nums[end] + a > 0) end--;
                else {
                    result.add(new ArrayList<>(Arrays.asList(a, nums[start], nums[end])));
                    start++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
