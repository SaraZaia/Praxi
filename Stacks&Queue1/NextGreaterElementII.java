//https://leetcode.com/problems/next-greater-element-ii/

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Map<Pair, Integer> results = new HashMap<>();
        
        int[] result = new int[nums.length];
            
        Stack<Pair> rest = new Stack<>();
        int x;
        for(int i = 0; i < 2* nums.length; i++) {
            x = nums[i%nums.length];
            while(!rest.isEmpty() && rest.peek().value < x) {
                results.put(rest.pop(), x);
            }
            if(!results.containsKey(new Pair(x,i%nums.length))) rest.add(new Pair(x,i%nums.length));
        }

        System.out.println(results.toString());
        int i = 0;
        for(int y : nums) {
            result[i] = results.getOrDefault(new Pair(y,i), -1);
            i++;
        }
        
        return result;
    }
    
    
    static public class Pair {
        int value;
        int index;
        
        Pair(int v, int i) {
            value = v; 
            index = i;
        }
        
        @Override
        public boolean equals(Object o) {
            if(o == this) return true;
            
            if(!(o instanceof Pair)) return false;
            
            Pair p = (Pair) o;
            return value == p.value && index == p.index;
        }
        
        
        @Override
        public int hashCode() {
            
            return index * 10000 +value;
        }
        
        @Override
        public String toString() {
            return "("+index + " : " + value + ")";
        }
    }
}
