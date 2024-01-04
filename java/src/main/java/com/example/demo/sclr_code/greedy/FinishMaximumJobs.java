/*
 * Q2. Finish Maximum Jobs

Problem Description
There are N jobs to be done, but you can do only one job at a time.
Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.

Problem Constraints
1 <= N <= 105
1 <= A[i] < B[i] <= 109

Input Format
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.

Output Format
Return an integer denoting the maximum number of jobs you can finish.

Example Input
Input 1:
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:
 A = [3, 2, 6]
 B = [9, 8, 9]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:
 Since all three jobs collide with each other. We can do only 1 job.

 */

package com.example.demo.sclr_code.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FinishMaximumJobs {

	public static void main(String[] args) {
		int[] sTime = {1, 5, 7, 1};
		int[] eTime = {7, 8, 8, 8};
		
		System.out.println( countOfMaxJobs(sTime, eTime) );
	}
	
	public static int countOfMaxJobs(int[] sTime, int[] eTime) {
		ArrayList<JobsTime> timing = new ArrayList<>();
		for(int i=0; i<sTime.length || i<eTime.length; i++) {
			timing.add(new JobsTime(sTime[i], eTime[i]) );
		}
		Collections.sort(timing, new JobsTime(0, 0));
		
		int ans = 1; 
		int prevEnd = timing.get(0).end;
		for(int i=1; i<timing.size(); i++) {
			if(timing.get(i).start >= prevEnd) {
				ans+=1;
				prevEnd = timing.get(i).end;
			}
		}
		return ans;
	}

}

class JobsTime implements Comparator<JobsTime>{
	int start;
	int end;
	JobsTime(int s, int e){
		start = s;
		end = e;
	}
	
	@Override
	public int compare(JobsTime o1, JobsTime o2) {
		return o1.end - o2.end;
//		if(o1.end < o2.end) {
//			return -1;
//		}else if(o1.end > o2.end) {
//			return 1;
//		}else {
//			return 0;
//		}
	}
}














