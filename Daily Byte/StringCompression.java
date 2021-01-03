//https://leetcode.com/problems/string-compression/

class StringCompression {
    public int compress(char[] chars) {
        int result = chars.length;
        int pointer = 0;
        
        int diffWindow = 0;
        
        for(int i = 0; i < chars.length; i++) {
            if(i == 0 || chars[i-1] != chars[i]) {
                if(diffWindow >= 2) {
                    chars[pointer++] = chars[i-1];
                    for(char c: (diffWindow +"").toCharArray()) {
                      chars[pointer++] = c;  
                    }
                } else {
                    if(i > 0) chars[pointer++] = chars[i-1];
                }
                diffWindow = 1;
            } else {
                diffWindow++;
            }
        }
        if(diffWindow >= 2) {
            chars[pointer++] = chars[chars.length - 1];
            for(char c: (diffWindow +"").toCharArray()) {
                chars[pointer++] = c;  
            }
        } else {
            chars[pointer++] = chars[chars.length - 1];
        }
        return pointer;   
    }
}
