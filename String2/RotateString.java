//https://leetcode.com/problems/rotate-string/

class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;

        String s = B+B;
        int i = s.indexOf(A);
        if(i == -1) return false;
        return true;
    }
}
