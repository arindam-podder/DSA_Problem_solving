/**
 * 1792. Maximum Average Pass Ratio

There is a school that has classes of students and each class will be having a final exam. You are given a 2D 
integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, 
there are totali total students, but only passi number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed 
to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total 
number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the 
actual answer will be accepted.

Example 1:
Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

Example 2:
Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485
 

Constraints:
1 <= classes.length <= 105
classes[i].length == 2
1 <= passi <= totali <= 105
1 <= extraStudents <= 105
 */


package com.example.demo.leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1792_MaximumAveragePassRatio {

	public static void main(String[] args) {
		

	}

	// use maxheap - greedy on gain
    public static double maxAverageRatio1(int[][] classes, int extraStudents) {
        PriorityQueue<GainRatio> maxHeap = new PriorityQueue<GainRatio>(new GainRatio());
        for(int i=0; i<classes.length; i++){
            maxHeap.add(new GainRatio(i, classes));
        }

        while(extraStudents>0){
            GainRatio gainRatio = maxHeap.poll();
            //add 1 extra student
            classes[gainRatio.index][0] += 1;
            classes[gainRatio.index][1] += 1;

            maxHeap.add(new GainRatio(gainRatio.index, classes ));
            extraStudents -= 1;
        }

        double max = 0;
        for(int[] cls : classes){
            max += (double) cls[0]/cls[1];
        }
        return max/classes.length;
    }


    static class GainRatio implements Comparator<GainRatio> {
    	
        double gain = 0;
        int index;
        int[][] classes;


        public GainRatio(){
        }
        public GainRatio(int idx, int[][] classes){
            this.index = idx;
            this.classes = classes;
            this.calculateGain();
        }


        void calculateGain(){
            int pass = this.classes[this.index][0];
            int total = this.classes[this.index][1];
            this.gain = ((double)(pass+1)/(total+1)) - ((double)pass/total);
        }


        @Override       //max will come first
        public int compare(GainRatio o1, GainRatio o2) {
            if(o1.gain > o2.gain ) return -1;
            else if(o1.gain < o2.gain) return 1;
            else return 0;
        }
    }
	
}
