/**
 * 2463. Minimum Total Distance Traveled

There are some robots and factories on the X-axis. You are given an integer array robot where robot[i] is the position of the ith robot. 
You are also given a 2D integer array factory where factory[j] = [positionj, limitj] indicates that positionj is the position of the jth 
factory and that the jth factory can repair at most limitj robots.

The positions of each robot are unique. The positions of each factory are also unique. Note that a robot can be in the same position as a 
factory initially.

All the robots are initially broken; they keep moving in one direction. The direction could be the negative or the positive direction of 
the X-axis. When a robot reaches a factory that did not reach its limit, the factory repairs the robot, and it stops moving.

At any moment, you can set the initial direction of moving for some robot. Your target is to minimize the total distance traveled by 
all the robots.

Return the minimum total distance traveled by all the robots. The test cases are generated such that all the robots can be repaired.

Note that
All robots move at the same speed.
If two robots move in the same direction, they will never collide.
If two robots move in opposite directions and they meet at some point, they do not collide. They cross each other.
If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.
If the robot moved from a position x to a position y, the distance it moved is |y - x|.
 

Example 1:
Input: robot = [0,4,6], factory = [[2,2],[6,2]]
Output: 4
Explanation: As shown in the figure:
- The first robot at position 0 moves in the positive direction. It will be repaired at the first factory.
- The second robot at position 4 moves in the negative direction. It will be repaired at the first factory.
- The third robot at position 6 will be repaired at the second factory. It does not need to move.
The limit of the first factory is 2, and it fixed 2 robots.
The limit of the second factory is 2, and it fixed 1 robot.
The total distance is |2 - 0| + |2 - 4| + |6 - 6| = 4. It can be shown that we cannot achieve a better total distance than 4.

Example 2:
Input: robot = [1,-1], factory = [[-2,1],[2,1]]
Output: 2
Explanation: As shown in the figure:
- The first robot at position 1 moves in the positive direction. It will be repaired at the second factory.
- The second robot at position -1 moves in the negative direction. It will be repaired at the first factory.
The limit of the first factory is 1, and it fixed 1 robot.
The limit of the second factory is 1, and it fixed 1 robot.
The total distance is |2 - 1| + |(-2) - (-1)| = 2. It can be shown that we cannot achieve a better total distance than 2.
 

Constraints:
1 <= robot.length, factory.length <= 100
factory[j].length == 2
-109 <= robot[i], positionj <= 109
0 <= limitj <= robot.length
The input will be generated such that it is always possible to repair every robot.
 
 */

package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC2463_MinimumTotalDistanceTraveled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long minimumTotalDistance1(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Map<Integer, Integer> factoryMap = new TreeMap<>();   //factory [position->repair count]
        int factoryMostLeft = Integer.MAX_VALUE;
        int factoryMostRight = Integer.MIN_VALUE;
        for(int[] a: factory) {
        	if(a[0]< factoryMostLeft) factoryMostLeft = a[0];
        	if(a[0]>factoryMostRight) factoryMostRight = a[0];
        	factoryMap.put(a[0], a[1]);    //a[0] is position, a[1] repair count
        }
        
        
        
    }
	
	//for each robot try left and right close option 
	public static int recur(int idx, List<Integer> robot, Map<Integer, Integer> factoryMap, int maxleft, int maxRight) {
		if(idx >= robot.size()) return 0; 
		
		int robotPosi = robot.get(idx); 
		//if robotPosi , already factory present and repair count greater than 0
		if(factoryMap.containsKey(robotPosi) && factoryMap.get(robotPosi)>0) {
			 factoryMap.put(robotPosi, factoryMap.get(robotPosi)-1);
			 return recur(idx+1, robot, factoryMap, maxleft, maxRight);
		}
		
		//else chose best from left and right nearest factory 
		
		
		return 0;
	}
	
	
	
	public static int getCost(int a, int b) {
		return Math.abs(a-b);
	}
	
	
	//undestand this tabulation
	public long minimumTotalDistance2(List<Integer> robot, int[][] factory) {
		Collections.sort(robot);
		Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

		List<Integer> factories = new ArrayList<>();
		for (int[] f : factory) {
			int pos = f[0], limit = f[1];
			for (int i = 0; i < limit; i++) {
				factories.add(pos);
			}
		}

		int r = robot.size(), f = factories.size();
		long[][] dp = new long[r + 1][f + 1];

		for (int i = 0; i <= r; i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE / 2);
		}

		for (int j = 0; j <= f; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= f; j++) {
				// Skip
				dp[i][j] = dp[i][j - 1];

				// Take
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - factories.get(j - 1)));
			}
		}

		return dp[r][f];
	}
}






