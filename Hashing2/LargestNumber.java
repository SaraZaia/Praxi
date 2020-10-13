//https://leetcode.com/problems/largest-number/

class LargestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, 
                   new Comparator<Integer>() {
            
                       @Override
                       public int compare(Integer o1, Integer o2) {
            
                String a = o1.toString();
                String b = o2.toString();
                int pA = 0;
                int pB = 0;
                int i = 0;
                while(i < b.length()+a.length() && (pB < b.length() || pA < a.length())){
                    i++;
                    if(a.charAt(pA) > b.charAt(pB)) return -1;
                    if(a.charAt(pA) < b.charAt(pB)) return 1;
                    if (a.charAt(pA) == b.charAt(pB)){
                        if(pA < a.length()-1) pA++;
                        else if(pA == a.length()-1) pA = 0;
                        
                        if(pB < b.length()-1) pB++;
                        else if(pB == b.length()-1) pB = 0;

                    }
                }

                return 0;    
            }
                   }
        );
        
        if(sorted[0] == 0) return "0";
        for(Integer x : sorted) {
            result.append(x);
            System.out.println(x);
        }
    
        return result.toString();
    }

}
