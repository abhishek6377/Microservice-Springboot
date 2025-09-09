package com.example.demo.util;

import java.util.Arrays;
import java.util.PriorityQueue;

import javax.sql.DataSource;

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
