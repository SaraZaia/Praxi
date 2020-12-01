//https://leetcode.com/problems/bag-of-tokens/


class BagOfTokens {
    int result = 0;
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int pStart = 0;
        int pEnd = tokens.length - 1;
        
        int score = 0;
        
        
        while(pStart <= pEnd) {
            while(pStart <= pEnd  && P >= tokens[pStart]) {
                P -= tokens[pStart];
                score++;
                pStart++;
            }
            result = Math.max(result, score);
            if(pEnd >= pStart && score > 0) {
                P += tokens[pEnd];
                score--;
                pEnd--;
            }
            if(pStart <= pEnd && P < tokens[pStart]) break;
        }
        
        return result;
    }
}
