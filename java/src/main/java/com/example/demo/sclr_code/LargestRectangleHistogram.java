/*
 * Q2. Largest Rectangle in Histogram

Problem Description
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000

Input Format
The only argument given is the integer array A.

Output Format
Return the area of the largest rectangle in the histogram.

Example Input
Input 1:
 A = [2, 1, 5, 6, 2, 3]
Input 2:
 A = [2]

Example Output
Output 1:
 10
Output 2:
 2

Example Explanation
Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:
Largest rectangle has area 2.
 */


package com.example.demo.sclr_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(90);
		list.add(58);
		list.add(69);
		list.add(70);
		list.add(82);
		list.add(100);
		list.add(13);
		list.add(57);
		list.add(47);
		list.add(18);
		
		System.out.println(largestRectangleArea(list));

	}
	
	public static int largestRectangleArea(ArrayList<Integer> A) {
        int ans = 0 ; 
        //find closest smaller value index on left for each element
        ArrayList<Integer> left = leftNearest(A);
        ArrayList<Integer> right = rightNearest(A);
        for(int i=0; i<A.size(); i++){
            int temp_area = A.get(i)* (right.get(i)-left.get(i)-1);
            ans = Math.max(ans, temp_area);
        }
        return ans;
    }


    public static ArrayList<Integer> leftNearest(ArrayList<Integer> A){
        ArrayList<Integer> ans = new ArrayList(); 
        Stack<Integer> st = new Stack(); 
        for(int i=0; i<A.size(); i++){
            Integer element = A.get(i); 
            while(!st.isEmpty() && A.get(st.peek()) >= element){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        return ans; 
    }
    public static ArrayList<Integer> rightNearest(ArrayList<Integer> A){
        ArrayList<Integer> ans = new ArrayList(A.size()); 
        Stack<Integer> st = new Stack(); 
        for(int i=A.size()-1; i>=0; i--){
            Integer element = A.get(i); 
            while(!st.isEmpty() && A.get(st.peek()) >= element){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(A.size());
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans; 
    }

}





















