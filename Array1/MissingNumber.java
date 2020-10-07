class MissingNumber {
    public int missingNumber1(int[] nums) {
        
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= i^nums[i];
        }
        result ^= nums.length;
        
        return result;
    }
    
    
    public int missingNumber2(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int x : nums) {
            numsSet.add(x);
        }
        for(int i=0; i <= nums.length; i++) {
            if(!numsSet.contains(i)) return i;
        }
        return 0;
        
    }
}
