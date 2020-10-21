//https://leetcode.com/problems/permutation-in-string/

class PermutationInString {
    
    // 1- Generate S1 permutations
    // 2- does S2 contains one? return true (Two Pointer)
    // return false 
    
    
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] arrS1 = new int[26];
        int[] arrS2 = new int[26];
        int window = s1.length();
        
        for(int i = 0; i <window ; i++) arrS1[getIndex(s1.charAt(i))] = arrS1[getIndex(s1.charAt(i))]+1;
        for(int i = 0; i <window ; i++) arrS2[getIndex(s2.charAt(i))] = arrS2[getIndex(s2.charAt(i))]+1;

        if(Arrays.equals(arrS1, arrS2)) return true;
        for(int i = window; i < s2.length(); i++) {
            arrS2[getIndex(s2.charAt(i))] = arrS2[getIndex(s2.charAt(i))]+1;
            arrS2[getIndex(s2.charAt(i-window))] = arrS2[getIndex(s2.charAt(i-window))]-1;
            if(Arrays.equals(arrS1, arrS2)) return true;
            
        }
        
        
        return false;
    }
    
    
    public int getIndex(char c) {
        return (int) (c - 'a');
    }
}
