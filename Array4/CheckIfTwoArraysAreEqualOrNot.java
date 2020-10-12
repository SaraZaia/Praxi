//https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not/0

import java.util.*;
import java.lang.*;
import java.io.*;
class CheckIfTwoArraysAreEqualOrNot
 {
	public static void main (String[] args)
	 {
	    Scanner in = new Scanner(System.in);
	    int T =Integer.parseInt(in.nextLine());
	    int N;
	    String[] line1;
	    String[] line2;
	    int result;
	    for(int j = 0;j < T; j++) {
	        result = 0;
	        N =Integer.parseInt(in.nextLine());
            line1 = in.nextLine().split("\\s+");            
            line2 = in.nextLine().split("\\s+");
            
            if(line1.length != line2.length) {
                System.out.println("0");
                return;
            }            
            Map<Integer, Integer> map = new HashMap<>();
            for(String x : line1) map.put(Integer.parseInt(x), map.getOrDefault(x,0)+1);
            

            
            for(String x: line2) {
                if(!map.containsKey(Integer.parseInt(x))){
                    System.out.println("0");
                    return;
                } else {
                    map.put(Integer.parseInt(x), map.get(Integer.parseInt(x))-1);
                    if(map.get(Integer.parseInt(x)) < 0){
                        System.out.println("0");
                        return;
                    }
                }
            }
	        
	        System.out.println("1");
	        
	    }
	 }
}
