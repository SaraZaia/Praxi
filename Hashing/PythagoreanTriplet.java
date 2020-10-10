//https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1

class PythagoreanTriplet {
    boolean checkTriplet(int[] arr, int n) {
        
        Set<Double> set = new HashSet<>();
        for(double x : arr) set.add(x);
        
        double a, b;
        
        for(int i = 0; i < arr.length; i++) {
            a = Math.pow(arr[i],2);
            for(int j = i+1; j < arr.length; j++) {
                b = Math.pow(arr[j],2);
                if(set.contains(Math.sqrt(a+b)) || set.contains(Math.sqrt(Math.abs(a-b))))
                    return true;
            }
        }
        return false;
    }
}
