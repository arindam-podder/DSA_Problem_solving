/**
 * 210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take 
course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
return any of them. If it is impossible to finish all courses, return an empty array.

 
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_CourseScheduleII {

	public static void main(String[] args) {
		int numCourses = 4, prerequisites[][] = {{1,0}, {2,0}, {3,1}, {3,2}};
		
		System.out.println( Arrays.toString( findOrder1(numCourses, prerequisites) ));
	}
	
	//topological khas algo rule logic
    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = getGraph(numCourses, prerequisites);
    	//inDegree setup 
    	int[] inDegree = new int[numCourses]; 
    	for(List<Integer> coursesList: graph) {
    		for(int course: coursesList) inDegree[course] += 1;
    	}
    	
    	//initial zero inDegree added to que 
    	Queue<Integer> que = new LinkedList<>(); 
    	for(int course=0; course<numCourses; course++) {
    		if(inDegree[course] == 0) que.add(course);
    	}
    	
    	int[] courseOrder = new int[numCourses];
    	int completedCourseCount = 0; 
    	while(!que.isEmpty()) {
    		int course = que.poll();
    		courseOrder[completedCourseCount] = course; 
    		completedCourseCount += 1;
    		for(int nextCourse: graph.get(course)) {
    			inDegree[nextCourse] -= 1; 
    			if(inDegree[nextCourse] == 0) {
    				que.add(nextCourse);
    			}
    		}
    	}
    	if(completedCourseCount != numCourses) {
    		return new int[]{};
    	}
    	
    	return courseOrder;
    }
    
    public static List<List<Integer>> getGraph(int n, int[][] preRequisites){
    	List<List<Integer>> graph = new ArrayList<>();
    	for(int i=0; i<n; i++) graph.add(new ArrayList<>());
    	for(int i=0; i<preRequisites.length; i++) {
    		graph.get(preRequisites[i][1]).add(preRequisites[i][0]);
    	}
    	return graph;
    }

}
