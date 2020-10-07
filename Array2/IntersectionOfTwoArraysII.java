//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> nums2Set = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int x : nums2) {
            if(nums2Set.containsKey(x)) nums2Set.compute(x, (k,v) -> v+1);
            else nums2Set.put(x, 1);
        }
        
        for(int x : nums1) {
            if(nums2Set.containsKey(x)) {
                if(nums2Set.get(x) > 0) {
                    result.add(x);
                    nums2Set.compute(x, (k,v) -> v-1);
                }
            }
        }
        int[] resArr = new int[result.size()];
        int i = 0;
        for(int x : result) resArr[i++] = x;
        
        return resArr;
        
    }
}
