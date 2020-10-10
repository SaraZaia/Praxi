//https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
         
        cascading(nums, result);
        
        return new ArrayList<List<Integer>> (result);
        
    }
    
    
    public void cascading(int[] nums, Set<List<Integer>> result) {
        Set<List<Integer>> tempResult = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        result.add(list);
        for(int x : nums) {
            tempResult = new HashSet<>();
            for(List<Integer> r : result ) {
                list = new ArrayList(r);
                list.add(x);
                tempResult.add(list);               
            }
            
            for(List<Integer> t : tempResult) {
                result.add(t);
            }
        }
    }
}
