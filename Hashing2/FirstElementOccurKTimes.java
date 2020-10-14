//https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times/0

import java.util.*;
import java.lang.*;
import java.io.*;
class FirstElementOccurKTimes
 {
     
     
     public static int firstOccur(int[] arr, int k) {
         int max = arr[0];
        Map<Integer, Integer> occur = new HashMap<>();
	    for(int x: arr) occur.put(x, occur.getOrDefault(x,0) + 1);
	    
	    for(int x: arr) if(occur.get(x) >= k) return x;
	    return -1;
     }
	public static void main (String[] args)
	 {
	     Scanner in = new Scanner(System.in);
	     int T = in.nextInt();
	     int n, k;
	     
	     for(int t = 0; t < T; t++) {
	         n= in.nextInt();
	         k= in.nextInt();
	         int[] arr = new int[n];
	         for(int i = 0; i < n; i++) arr[i] = in.nextInt();
	         System.out.println(firstOccur(arr, k));

	     }

	 }
}
