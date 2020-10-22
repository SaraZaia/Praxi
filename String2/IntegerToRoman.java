//https://leetcode.com/problems/integer-to-roman/submissions/

class IntegerToRoman {
    public String intToRoman(int num) {     
        StringBuilder sb = new StringBuilder();
        
        int[] numbers = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};        
        String[] symbols = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        
        int pointer = numbers.length - 1;
        while(num != 0) {
            while(numbers[pointer] > num ) {
                pointer--;
            }    
            
            num = num - numbers[pointer];
            sb.append(symbols[pointer]);
        }        
        return sb.toString();
    }
}
