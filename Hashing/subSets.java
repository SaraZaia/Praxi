//https://leetcode.com/problems/subsets/

class subSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> propo = new ArrayList<>();
        result.add(propo);
        
        for(int x: nums) {
             list = new ArrayList<>();
            for(List<Integer> r : result) {
                propo = new ArrayList<>(r);
                propo.add(x);
                list.add(propo);
            }
            
            for(List<Integer> l : list) {
                result.add(new ArrayList<>(l));
            }
        }
        return result;              
    }
}
