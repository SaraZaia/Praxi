//https://leetcode.com/problems/two-sum/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // value & index
        int i = 0;
        for(int x : nums) map.put(x,i++);
        
        i = 0;
        for(int x : nums) {            
            if(map.containsKey(target-x) && i != map.get(target-x)) 
            {
                System.out.println(x);
                result[0] = map.get(target-x);              
                result[1] = i;
                return result;
            }
            i++;
        }
        return result;
    }
}
