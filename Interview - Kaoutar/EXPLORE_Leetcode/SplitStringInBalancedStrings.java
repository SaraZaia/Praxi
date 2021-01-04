//https://leetcode.com/problems/split-a-string-in-balanced-strings/

class SplitStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int Lcount = 0;
        int Rcount = 0;
        
        int result = 0;
        int index = 0;
        
        while(index < s.length()) {
            if(s.charAt(index) == 'L') Lcount++;
            if(s.charAt(index) == 'R') Rcount++;
            if(Lcount == Rcount) {
                result++;
                Lcount = 0;
                Rcount = 0;
            }
            index++;
        }
        return result;
    }
}
