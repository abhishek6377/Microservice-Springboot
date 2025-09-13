package com.example.demo.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Demo {
	
	public static void main(String[] args) {
		
//		int []nums = {3,2,1,5,6,4}; 
//		int k = 2;
//				
//		PriorityQueue<Integer> integers = new PriorityQueue<>();
//		
//		for (int i = 0; i < nums.length; i++) {
//		       integers.add(nums[i]);
//		}
//		
//		while (!integers.isEmpty()) {
//			System.out.print(integers.peek()+" ");
//		}
//		
		
		int[] noZeroIntegers = getNoZeroIntegers(1010);
		System.out.println(Arrays.toString(noZeroIntegers));
		
		int maxFreqSum = maxFreqSum("successes");
		
		System.out.println(maxFreqSum);
		
	}
	
     public static int maxFreqSum(String s) {
           char[] charArray = s.toCharArray();
           TreeMap<Character, Integer> vowels = new TreeMap<>();
           TreeMap<Character, Integer> constMap = new TreeMap<>();
           for (char c : charArray) {
        	   char lowerCase = Character.toLowerCase(c);
				if (lowerCase == 'a' || lowerCase == 'i' || lowerCase == 'e' || lowerCase == 'o' || lowerCase == 'u') {
					  vowels.put(lowerCase, vowels.getOrDefault(lowerCase, 0)+1);
				} else {
					constMap.put(lowerCase, constMap.getOrDefault(lowerCase, 0)+1);
				}
			
		  }
           
           Integer v = vowels.entrySet().stream().map(e->e.getValue())
           .sorted(Comparator.reverseOrder()).findFirst().orElse(0);
           
           Integer c = constMap.entrySet().stream().map(e->e.getValue())
                   .sorted(Comparator.reverseOrder()).findFirst().orElse(0);
           
           System.out.println(vowels.toString());
           System.out.println(constMap.toString());
	      return v+c;
    }
	
	
	 public  static int[] getNoZeroIntegers(int n) {
	        for (int i = 1; i < n; i++) {
	        	  int j = n - i;
	              if (checkZezo(i) && checkZezo(j)) {
	                  return new int[]{i, j};
	              }
				}
	        return new int[]{};
	    }
	 
	 public static boolean checkZezo(int num) {
		 while (num > 0) {
	            if (num % 10 == 0) {
	                return false;
	            }
	            num /= 10;
	        }
	        return true;
	 }

}
