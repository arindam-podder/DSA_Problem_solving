/*
 * Q3. Flip and Find Nearest

Problem Description
Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.

Each query has 2 integers :-
First integer denotes the type of query. Type of query can be either 1 or 2.
Second integer denotes index x.
If type = 1, Flip the value at index x.

If type = 2, Find the index of the nearest 1 to the left or right of index x in the array. 
If there are multiple indices has the same distance from x, return the index with the lower value. 
If there is no occurrence of 1 in the array, return -1.

Note :
We use 1-based indexing

Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= B[i][0] <= 2
1 <= B[i][1] <= N

Input Format
First argument A is a string.
Second argument B is a 2D array of integers describing the queries.

Output Format
Return an array of integers denoting the answers to each query of type 2.

Example Input
Input 1:
A = "10010"
B = [[1, 2]
     [2, 3]]
Input 2:
A = "010000100"
B = [[2, 5]
     [1, 7]
     [2, 9]]

Example Output
Output 1:
[2]
Output 2:
[7, 2]

Example Explanation
For Input 1:
After first query, A = "11010".
For second query, X = 3. Both index 2 and index 4 are at the same 
distance but we choose the lower index.
For Input 2:
For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
index 7.
After second query, A = "010000000"
For third query, the only index with '1' is 2.
 */

package com.example.demo.sclr_code;

import java.util.Arrays;
import java.util.TreeSet;

public class FlipAndFindNearest {

	public static void main(String[] args) {
		String A = "10010";		//idx = 0 1 2 3 4
		
		//System.out.println(check(A));
		
		int[][] B = { {1,3}, {1,3}, {2,4}, {2,2}, {1,1}, {2,3}, {1,5}, {1,5} };
		
		System.out.println(Arrays.toString(solve(A, B)));
		
				
	}
	
	public static int[] solve(String A, int[][] B) {
		int totalType2 = 0; 
		for(int i=0; i<B.length; i++) {
			if(B[i][0]==2) {
				totalType2++;
			}
		}
		
		TreeSet<Integer> ts_index = new TreeSet<>();
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i)=='1') {
				ts_index.add(i);
			}
		}
		
		int[] ans = new int[totalType2];
		int ans_index=0;
		//itarate over queries
		for(int i=0; i<B.length; i++) {
			if(B[i][0]==1) {		//flip operation
				int idx=B[i][1]-1;
				if(A.charAt(idx)=='0') {
					if(idx==0) {
						A = "1"+A.substring(idx+1);
					}else if(idx==A.length()-1) {
						A= A.substring(0, idx)+"1";
					}
					else {
						A = A.substring(0, idx)+"1"+A.substring(idx+1);
					}
					ts_index.add(idx);
				}else {
					if(idx==0) {
						A = "0"+A.substring(idx+1);
					}else if(idx==A.length()-1) {
						A= A.substring(0, idx)+"0";
					}
					else {
						A = A.substring(0, idx)+"0"+A.substring(idx+1);
					}
					ts_index.remove(idx);
				}
			}//flip opeartion done 
			else {						//if type is 2
				int idx = B[i][1]-1; 		// -1 becoze 1based index given
				if(ts_index.contains(idx)) {
					ans[ans_index]=idx+1; 
					ans_index++;
				}else if(ts_index.ceiling(idx) == null && ts_index.floor(idx) != null) {		//left part
					ans[ans_index]= ts_index.floor(idx)+1; 
					ans_index++;
				}else if(ts_index.floor(idx)==null && ts_index.ceiling(idx)!=null) {		//right part
					ans[ans_index] = ts_index.ceiling(idx) + 1;
					ans_index++;
				}else if(ts_index.floor(idx)==null && ts_index.ceiling(idx)==null) {
					ans[ans_index]=-1;
					ans_index++;
				}else {
					ans[ans_index] = idx-ts_index.floor(idx)<= ts_index.ceiling(idx)-idx ? ts_index.floor(idx)+1 : ts_index.ceiling(idx)+1;
					ans_index++;
				}
			}
		}
		return ans;
	}

}




















