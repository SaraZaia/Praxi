//https://leetcode.com/problems/license-key-formatting/

class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase().replaceAll("\\-", "");
        int n = S.length();
        int first = n % K;
        int pas = n/K;
        StringBuilder sb = new StringBuilder(); 
        int pStart = 0;
        int pEnd = 0;
        if( first >= 1) {
            pEnd = first;
            sb.append(S.substring(pStart, pEnd));
            if(pEnd < S.length()) sb.append("-");
            pStart = pEnd;
            pEnd += K;
        } else {
            pEnd = K;
        }
        
        while(pEnd <= S.length()) {
            sb.append(S.substring(pStart, pEnd));
            if(pEnd < S.length())sb.append("-");
            pStart = pEnd;
            pEnd += K;
        }
        
        return sb.toString(); 
        
    }
}
