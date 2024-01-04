/*
 * Q4. Fractional Knapsack (Day 86 - Advanced DSA : DP 3: Knapsack -- Wed, 11 Oct 2023)
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , 
i.e., floor of (ans × 100).

NOTE:
You can break an item for maximizing the total value of the knapsack

Problem Constraints
1 <= N <= 105
1 <= A[i], B[i] <= 103
1 <= C <= 103

Input Format
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.

Output Format
Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.

Example Input
Input 1:
 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:
 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10

Example Output
Output 1:
 24000
Output 2:
 2105

Example Explanation
Explanation 1:
Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us 
the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
Explanation 2:
Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
 */

package com.example.demo.sclr_code.dynamic_programing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {
	public static void main(String[] args) {
		
	}
	
	public static int fractionalMaxValue(int[] value, int[] weight, int knapsackCapacity){
		ArrayList<PairFraction> pairFractions = new ArrayList<PairFraction>(); 
		//traverse element get fraction = value/weight, store in pairFractions list 
		for(int i=0; i<value.length; i++){
			 pairFractions.add( new PairFraction( ((double)value[i])/weight[i], i) );
		}
		Collections.sort(pairFractions, new PairFraction());
		
		double ans = 0; 
		for(PairFraction pf : pairFractions){
			if(weight[pf.index] <= knapsackCapacity){
				ans += value[pf.index];
				knapsackCapacity -= weight[pf.index]; 
			}else{
				ans += pf.fraction * knapsackCapacity;
				break;
			}
		}
		return  (int)(ans*1000)/10;  
	}
}


/**
 * this class is to store the fraction and index of value & weight  
 * @author Arindam Podder
 *
 */
class PairFraction implements Comparator<PairFraction>{
	double fraction; 
	int index; 
	PairFraction() {
	}
	
	PairFraction(double f, int i){
		this.fraction = f;
		this.index = i; 
	}
	
	@Override
	public String toString() {
		return "Pair = [fraction-"+this.fraction+", index-"+this.index+"]";	
	}
	
	@Override
	public int compare(PairFraction arg0, PairFraction arg1) {		//desc sorting , we need max fraction first
		if(arg0.fraction < arg1.fraction) return 1; 
		else if(arg0.fraction > arg1.fraction) return -1; 
		else return 0; 
	}

}













