//https://leetcode.com/problems/partition-equal-subset-sum/

class PartitionEqualSubsetSum {
        int n = nums.length - 1;
        int sum = 0;
        int max = nums[0];
        
        for(int x : nums) {
            sum += x;
            if(x > max) max = x;
        }
        if(sum % 2 != 0) return false;
        int avr = sum / 2;
        
        if(max > avr) return false;
        
        // look for list sum == avr
        
        return canPartitionO1Knapsack(nums, avr);
       //return dfs(nums, n, avr);
    }
    
    
    //Solution with DFS: Brute Force Solution
    public boolean dfs(int[] nums, int n, int avr ) {
        if(avr == 0) return true;
        if(n == 0 || avr < 0) return false;
        
        return dfs(nums, n-1, avr - nums[n-1]) || dfs(nums, n-1, avr);     
    }
    
    
    //Solution with 0/1 Knapsack problem
    public boolean canPartitionO1Knapsack(int[] nums, int avr) {
        
        int a;
        int[][] result = new int[nums.length][avr];
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j <= avr; j++) {
                
                if(i == 0){
                    if(j <  nums[i]) result[i][j-1] = 0;
                    else result[i][j-1] = nums[i];
                } else{           
                    a =j-1-nums[i]>=0? result[i-1][j-1-nums[i]] + nums[i]: 0;
                    result[i][j-1] = Math.max(result[i-1][j-1], a);
                    if(result[i][j-1] == avr) return true;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(result));
        return false;
    }

    
    
    
    
}
