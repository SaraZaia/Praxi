//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class letterCombinationsOfPhoneNumber {
    
    Map<Character, String> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        if(digits.length() == 0 ) return result;
        StringBuilder res = new StringBuilder();
        recursion(digits, result, 0, res);
        return result;
    }
    
    
    public void recursion(String digits, List<String> result, int position, StringBuilder res) {
        
        if(position > digits.length() - 1) {
            result.add(res.toString());
            return;
        }
        char cc = digits.charAt(position);
        
        for(char c : map.get(cc).toCharArray()) {
            res.append(c);
            recursion(digits, result, position + 1, res);
            res.deleteCharAt(res.length() - 1);
        }
                
    }

    
}
