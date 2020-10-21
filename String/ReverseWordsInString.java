//https://leetcode.com/problems/reverse-words-in-a-string/

class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] splitString = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        System.out.println(splitString.length);
        for(int i = 0; i < splitString.length-1; i++) {
            result.insert(0, " " + splitString[i]);
        }
        result.insert(0, splitString[splitString.length-1]);

        return result.toString();     
    }
}
