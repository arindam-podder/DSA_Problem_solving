/*
 * Q3. Possibility of Finishing (Day 91 - Advanced DSA : Graphs 2: Tological Sort & DSU -- Fri, 27 Oct 2023)
Problem Description
There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1, 
which is expressed as a pair: [1,2].
So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints
1 <= A <= 6*104
1 <= length(B) = length(C) <= 105
1 <= B[i], C[i] <= A

Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.

Output Format
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Example Input
Input 1:
 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:
 A = 2
 B = [1, 2]
 C = [2, 1]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 It is possible to complete the courses in the following order:
    1 -> 2 -> 3
Explanation 2:
 It is not possible to complete all the courses.
 */

package com.example.demo.sclr_code.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class PossibilityOfFinishing_TopologicalSort {
	public static void main(String[] args) {
		
	}
	
	public static int checkPossibility(int A, int[] B, int[] C) {
		ArrayList<ArrayList<Integer>> graphsList = new ArrayList<ArrayList<Integer>>();
		//add emty list A times 
		for(int i=0; i<=A; i++){
			graphsList.add(new ArrayList<Integer>());
		}
		int[] inDegree = new int[A+1];				//inDegree defines the number of incoming edges to a particular node/component/element  
		//create the adjacency list 
		for(int i=0; i<B.length; i++){
			int parent = B[i]; 
			int child = C[i]; 
			graphsList.get(parent).add(child);
			inDegree[child] += 1; 
		}
		
		LinkedList<Integer> que = new LinkedList<Integer>(); 
		//add all element with inDegree 0 in the que 
		for(int i=1; i<=A; i++){		//loop should start with 1 , bcoz nodes are 1-A 
			if(inDegree[i] == 0){
				que.offerLast(i); 
			}
		}
		
		while(!que.isEmpty()){
			int course = que.pollFirst(); 
			ArrayList<Integer> dependentCourseList =  graphsList.get(course); 
			for(int i=0; i<dependentCourseList.size(); i++){
				int dependentCourse = dependentCourseList.get(i); 
				inDegree[dependentCourse] -= 1; 
				if(inDegree[dependentCourse] == 0){
					que.offerLast(dependentCourse); 
				}
			}
		}
		
		
		//now if inDegree all value ZERO , means all course are possible to finish 
		for(int i=0; i<inDegree.length; i++){
			if(inDegree[i] != 0){
				return 0;
			}
		}
		return 1; 
	}
}












