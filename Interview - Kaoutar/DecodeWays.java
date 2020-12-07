//https://leetcode.com/problems/decode-ways/


class DecodeWays {
    Map<String, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        return dp(s, 0, 1) + dp(s, 0, 2);
    }
    
    
    int dp(String s, int position, int choice) {
        if(memo.containsKey(position+" - " + choice)) return memo.get(position+" - " + choice);
        if( position+choice > s.length()) return 0;
        
        int number = Integer.parseInt(s.substring(position, position+choice));
        
        if( number < 1 || number > 26 || s.charAt(position) == '0') return 0;
        else if( number >= 1 && number <= 26 && position+choice == s.length()) {
            return 1;
        }
        int result = dp(s, position+choice, 1) + dp(s, position+choice, 2);
        memo.put(position+" - " + choice, result);
        return result;
    }
}
