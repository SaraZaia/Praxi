//https://leetcode.com/problems/roman-to-integer/

class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("I",1);
        symbols.put("V",5);
        symbols.put("X",10);
        symbols.put("L",50);
        symbols.put("C",100);
        symbols.put("D",500);
        symbols.put("M",1000);
        
        int result = 0;
        int k = 0;
        String current;
        String next;
        int number;
        
        while (k < s.length() - 1) {
            current = s.charAt(k)+"";
            next = s.charAt(k+1)+"";
            
            if(symbols.get(current) >= symbols.get(next))
            {
                number = symbols.get(current);
            } else {
                number =  symbols.get(next) - symbols.get(current);
                k++;
            }
            
            result += number;
            k++;
        }
        if(k == s.length() - 1) result += symbols.get(s.charAt(s.length() - 1)+"");
        
        return result;
    }
}
