/*
 * 43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, 
also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 
Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * 
 * 
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LC43_MultiplyStrings {

	public static void main(String[] args) {
		//String s = "23";
		//System.out.println( Integer.valueOf(s.charAt(0)+"") );
	
		System.out.println( multiply1("123", "456") );
		System.out.println( multiply2("123", "456") );
	
	}
	
	
	//list of list , each inner list will be the multiplication value holder
	public static String multiply1(String num1, String num2) {
		List<List<Integer>> values = new ArrayList<>(num1.length() * num2.length());
		for(int i=0; i<num1.length() * num2.length(); i++) { 
			values.add(new ArrayList<>());
		}
		int globalIdx = 0; 
		int carry = 0;
		for(int i=num1.length()-1; i>=0; i--) {
			int localIdx = globalIdx;
			int n1 = Integer.valueOf(num1.charAt(i)+"");
			for(int j=num2.length()-1; j>=0; j--) {
				int n2 = Integer.valueOf(num2.charAt(j)+"");
				
				int calculation = (n1 * n2) + carry; 
				int val = calculation%10; 
				carry = calculation/10;
				values.get(localIdx).add(val);
				localIdx += 1;
			}
			if(carry > 0) values.get(localIdx).add(carry);
			carry = 0;
			globalIdx += 1; 
		}
		
		String result = ""; 
		carry = 0; 
		for(List<Integer> l: values) {
			if(l.size() == 0) break;
			int sum = l.stream().mapToInt(a -> a).sum();
			int calculation = sum + carry; 
			int val = calculation%10; 
			carry = calculation/10;
			result = val + result;
		}
		
		if(carry > 0) result = carry + result;
		
		return result.replaceFirst("^0+(?!$)", "");   //remove all leading Zero
		
    }
	
	
	//list will be the multiplication value holder sum will in place 
		public static String multiply2(String num1, String num2) {
			List<Integer> values = new ArrayList<>();
			for(int i=0; i<num1.length() * num2.length() + 1; i++) { 
				values.add(0);
			}
			int globalIdx = 0; 
			int carry = 0;
			for(int i=num1.length()-1; i>=0; i--) {
				int localIdx = globalIdx;
				int n1 = Integer.valueOf(num1.charAt(i)+"");
				for(int j=num2.length()-1; j>=0; j--) {
					int n2 = Integer.valueOf(num2.charAt(j)+"");
					
					int calculation = (n1 * n2) + carry; 
					int val = calculation%10; 
					carry = calculation/10;
					//values.get(localIdx).add(val);
					values.set(localIdx, values.get(localIdx)+val);
					localIdx += 1;
				}
				if(carry > 0) values.set(localIdx, values.get(localIdx)+carry);
				carry = 0;
				globalIdx += 1; 
			}
			
			String result = ""; 
			carry = 0; 
			for(int a:values) {
				//int sum = l.stream().mapToInt(a -> a).sum();
				int calculation = a + carry; 
				int val = calculation%10; 
				carry = calculation/10;
				result = val + result;
			}
			
			if(carry > 0) result = carry + result;
			
			return result.replaceFirst("^0+(?!$)", "");   //remove all leading Zero
			
	    }
	
}
