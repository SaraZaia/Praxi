//https://leetcode.com/problems/uncommon-words-from-two-sentences/

class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        
        int pA = 0;
        int pB = 0;
        String[] aStr = A.split("\\s+");
        Arrays.sort(aStr);        
        String[] bStr = B.split("\\s+");
        Arrays.sort(bStr);
        int countA = 0;
        int countB = 0;
        int k = 0;
        
        String[] result = new String[A.length() + B.length()];
        
        while(pA < aStr.length && pB < bStr.length){

            while(pA+1 < aStr.length && aStr[pA].equals(aStr[pA+1])) {
                pA++;
                countA++;
            }
            
            while(pB+1 < bStr.length && bStr[pB].equals(bStr[pB+1])) {
                pB++;
                countB++;
            }
            System.out.println(countA + " *** " + aStr[pA] + "   <-" + pA);
            System.out.println(countB + " *** " + bStr[pB] + "   <-" + pB);
            System.out.println("--------------");
            
            if(!aStr[pA].equals(bStr[pB])) {
                if(aStr[pA].compareTo(bStr[pB])<0){
                    if(countA == 0) result[k++] = aStr[pA]; 
                    pA++;
                    countA = 0;
                }
                else if(aStr[pA].compareTo(bStr[pB])>0){
                    if( countB == 0) result[k++] = bStr[pB];
                    pB++;
                    countB = 0;
                } 
            } else {
                countA = 0;
                countB = 0;
                pA++;
                pB++;
            }
            
        }
        
        while(pB < bStr.length) {
            System.out.println(bStr[pB] + " countB " + countB);

            while(pB+1 < bStr.length && bStr[pB].equals(bStr[pB+1])) {
                pB++;
                countB++;
            }
            if(countB ==0 ) {result[k++] = bStr[pB]; }
            pB++;
            countB = 0;
        }        
        while(pA < aStr.length) {

            System.out.println(aStr[pA]);
            while(pA+1 < aStr.length && aStr[pA].equals(aStr[pA+1])) {
                pA++;
                countA++;
            }
            if(countA == 0) result[k++] = aStr[pA]; 
            pA++;
             countA = 0;
        }
        

        return Arrays.copyOfRange(result, 0, k);
    }
}
