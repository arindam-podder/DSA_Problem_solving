/**
 * 207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take 
course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. 
So it is impossible.
 
Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC207_CourseSchedule {

	public static void main(String[] args) {
		int numCourses = 2, prerequisites[][] = {{1,0}, {0,1}};
		
		System.out.println( canFinish1(numCourses, prerequisites) );
	}
	
	//1.do khans algio, topological sort mechanism, check visitedVertexCount == numCourses or not 
    //OR
	//2. cycle detect logic if cycle then not possible 
	public static boolean canFinish1(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = getGraph(numCourses, prerequisites);
		//inDegree setup 
    	int[] inDegree = new int[numCourses]; 
    	for(int i=0; i<numCourses; i++) {
    		for(int course: graph.get(i)) inDegree[course] += 1;
    	}
    	
    	//get initial Zero indegrees courses 
    	Queue<Integer> que = new LinkedList<>(); 
    	for(int course=0; course<inDegree.length; course++) {
    		if(inDegree[course] == 0) que.add(course); 
    	}
    	
    	int courseCompleted = 0;
    	while(!que.isEmpty()) {
    		int course = que.poll();
    		courseCompleted += 1; 
    		for(int nextCourse: graph.get(course)) {
    			inDegree[nextCourse] -= 1; 
    			if(inDegree[nextCourse] == 0) {
    				que.add(nextCourse);
    			}
    		}
    	}
    	
    	return courseCompleted == numCourses; 	
    }
    
    public static List<List<Integer>> getGraph(int numCourses, int[][] prerequisites){
    	List<List<Integer>> graph = new ArrayList<>(); 
    	for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>()); 
    	for(int[] preRequisite: prerequisites) {
    		graph.get(preRequisite[1]).add(preRequisite[0]);
    	}
    	return graph;
    }
}
