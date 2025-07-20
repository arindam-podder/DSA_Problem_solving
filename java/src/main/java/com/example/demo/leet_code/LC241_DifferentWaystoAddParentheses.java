/**
 * 241. Different Ways to Add Parentheses

Given a string expression of numbers and operators, return all possible results from computing all the different possible
ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different
results does not exceed 104.


Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:
1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC241_DifferentWaystoAddParentheses {
	public static void main(String[] args) {
		String s  = "2*3-4*5";
		
		System.out.println( getListExpression(s)  );
		System.out.println( diffWaysToCompute1(s) );
	}
	
	 public static List<Integer> diffWaysToCompute1(String expression) {
		 List<String> listExpression = getListExpression(expression);
		 
		 //return recur(listExpression, 0, listExpression.size()-1);
		 
		 List<Integer>[][] dp = new ArrayList[listExpression.size()][listExpression.size()];
 		 return memorize(listExpression, 0, listExpression.size()-1, dp);
	 }
	 
	 
	 public static List<String> getListExpression(String s){
		 List<String> listExpr = new ArrayList<>();
		 String cur = "";
		 for(int i=0; i<s.length(); i++) {
			 if(s.charAt(i) == '*' || s.charAt(i) == '-' || s.charAt(i) == '+' ) {
				 listExpr.add(cur);
				 listExpr.add(""+s.charAt(i)); 
				 cur = "";
			 }else {
				 cur = cur + s.charAt(i);
			 }
		 }
		 listExpr.add(cur);
		 return listExpr;
	 }
	 
		public static boolean isInteger(String s) {
			if (s == null || s.isEmpty())
				return false;
			try {
				Integer.parseInt(s); 
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	 
	 
	 public static List<Integer> recur(List<String> expr, int start, int end){
		 List<Integer> res = new ArrayList<>();
		 // base case 
		 if(start == end) {
			 res.add(Integer.parseInt(expr.get(start)));
			 return res;
		 }
		 
		 for(int i=start; i<=end; i++) {
			 if( isInteger(expr.get(i)) ) continue;
			 
			 String operator = expr.get(i);
			 List<Integer> left = recur(expr, start, i-1);
			 List<Integer> right = recur(expr, i+1, end);
			 
			 for(int l : left) {
				 for(int r : right) {
					 if(operator.equals("*")) {
						 res.add(l*r);
					 }else if(operator.equals("+")) {
						 res.add(l+r);
					 }else {
						 res.add(l-r);
					 }
				 }
			 }
		 }
		 
		 return res;
	 }
	 
	 
	 
	 //memorize
	 public static List<Integer> memorize(List<String> expr, int start, int end, List<Integer>[][] dp){
		 List<Integer> res = new ArrayList<>();
		 // base case 
		 if(start == end) {
			 res.add(Integer.parseInt(expr.get(start)));
			 return res;
		 }
		 
		 if(dp[start][end] != null) return dp[start][end];
		 
		 for(int i=start; i<=end; i++) {
			 if( isInteger(expr.get(i)) ) continue;
			 
			 String operator = expr.get(i);
			 List<Integer> left = memorize(expr, start, i-1, dp);
			 List<Integer> right = memorize(expr, i+1, end, dp);
			 
			 for(int l : left) {
				 for(int r : right) {
					 if(operator.equals("*")) {
						 res.add(l*r);
					 }else if(operator.equals("+")) {
						 res.add(l+r);
					 }else {
						 res.add(l-r);
					 }
				 }
			 }
		 }
		 dp[start][end] = res;
		 return dp[start][end];
	 }
	 
	 
	
	
}



















