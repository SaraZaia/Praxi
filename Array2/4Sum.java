//https://leetcode.com/problems/4sum/submissions/
class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        int a, b, c, d;
        
        Arrays.sort(nums);
        int start = 0;
        int end = n - 1;
        int newTarget;
        
        for(int i =0; i < n; i++) {
            a = nums[i];
            for(int j =i+1; j < n; j++) {
                b = nums[j];
                start = j+1;
                end = n-1;
                
                newTarget = target - a - b;
                while(start < end) {
                    c = nums[start];
                    d = nums[end];
                    if(c + d < newTarget) start++;
                    else if(c + d > newTarget ) end--;
                    else {
                        result.add(new ArrayList<>(Arrays.asList(a,b,c, d)));
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(result); 
    }
}
