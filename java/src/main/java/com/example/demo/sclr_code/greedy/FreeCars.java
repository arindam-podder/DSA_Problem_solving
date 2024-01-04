/*
 * Q3. Free Cars

Problem Description
Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.

B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, 
so you can only buy the ith car when the current time <= A[i] - 1.
Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:
You can start buying from time = 0.
Return your answer modulo 10^9 + 7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9

Input Format
The first argument is an integer array A represents the deadline for buying the cars.
The second argument is an integer array B represents the profit obtained after buying the cars.

Output Format
Return an integer denoting the maximum profit you can earn.

Example Input
Input 1:
 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
Input 2:
 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]

Example Output
Output 1:
 20
Output 2:
 30

Example Explanation
Explanation 1:
 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
Explanation 2:
 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
 */


package com.example.demo.sclr_code.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {

	public static void main(String[] args) {
		int[] time = {1, 3, 2, 3, 3, 3};
		int[] prifit = {5, 6, 1, 3, 9, 12};
		
		System.out.println(maximumProfit(time, prifit));
	}
	
	public static int maximumProfit(int[] A, int[] B) {
		int mod = 1000000007;
		ArrayList<CarProfit> carProfit = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			carProfit.add(new CarProfit(A[i], B[i]));
		}
		Collections.sort(carProfit, new CarProfit());
		long ans = 0; 
		PriorityQueue<Integer> profit = new PriorityQueue<>(); //MinHeap
		int currentTime = 0;
		for(int i=0; i<carProfit.size(); i++) {
			if(currentTime < carProfit.get(i).time) {
				ans = (ans + carProfit.get(i).profit)%mod;
				currentTime+=1;
				profit.add(carProfit.get(i).profit);
			}else {
				if(!profit.isEmpty() && carProfit.get(i).profit > profit.peek()) {
					ans = ans - profit.poll();
					ans = (ans + carProfit.get(i).profit)%mod;
					profit.add(carProfit.get(i).profit);
				}
			}
		}
		return (int)ans;
	}

}


class CarProfit implements Comparator<CarProfit>{
	int time;
	int profit;
	public CarProfit() { }
	CarProfit(int t, int p){
		time = t;
		profit = p;
	}
	
	@Override
	public int compare(CarProfit o1, CarProfit o2) {
		return o1.time - o2.time;
	}
}














