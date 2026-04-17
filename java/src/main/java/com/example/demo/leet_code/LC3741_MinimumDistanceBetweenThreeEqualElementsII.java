/**
 * 3741. Minimum Distance Between Three Equal Elements II

You are given an integer array nums.

A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.

Example 1:
Input: nums = [1,2,1,1,3]
Output: 6
Explanation:
The minimum distance is achieved by the good tuple (0, 2, 3).
(0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.

Example 2:
Input: nums = [1,1,2,3,2,1,2]
Output: 8
Explanation:
The minimum distance is achieved by the good tuple (2, 4, 6).
(2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2. Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.

Example 3:
Input: nums = [1]
Output: -1
Explanation:
There are no good tuples. Therefore, the answer is -1.

Constraints:
1 <= n == nums.length <= 105
1 <= nums[i] <= n
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//has a easy version of this 3740. Minimum Distance Between Three Equal Elements I - here constrain small 
public class LC3741_MinimumDistanceBetweenThreeEqualElementsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// TLE 
	public int minimumDistance1(int[] nums) {
        int result = -1; 
        Map<Integer, List<Integer>> numPosition = new HashMap<>(); 
        for(int i=0; i<nums.length;  i++){
            int n = nums[i];
            if(numPosition.containsKey(n)){
                numPosition.get(n).add(i); 
                int dis = getDistance(numPosition.get(n)); 
                if(dis != -1){
                    if(result == -1) result = dis; 
                    else{
                        result = Math.min(result, dis);
                    }
                }
            }else{
                numPosition.put(n, new ArrayList());
                numPosition.get(n).add(i);
            }
        } 
        return result;
    }

    public static int getDistance(List<Integer> posi){
        if(posi.size()<3){
            return -1;
        }
        int best = Integer.MAX_VALUE;
        //window wise chcek the best distance 
        for(int i=0; i<posi.size()-2; i++){
            int a = posi.get(i);
            int b = posi.get(i+1);
            int c = posi.get(i+2);
            best = Math.min(best, Math.abs( (a-b) ) + Math.abs( (b-c) ) + Math.abs( (c-a) ) );
        }

        return best;   
    }

    
    
    //in get distance calculate only for last 3 , not all for each time 
    public int minimumDistance2(int[] nums) {
        int result = -1; 
        Map<Integer, List<Integer>> numPosition = new HashMap<>(); 
        for(int i=0; i<nums.length;  i++){
            int n = nums[i];
            if(numPosition.containsKey(n)){
                numPosition.get(n).add(i); 
                int dis = getDistance(numPosition.get(n)); 
                if(dis != -1){
                    if(result == -1) result = dis; 
                    else{
                        result = Math.min(result, dis);
                    }
                }
            }else{
                numPosition.put(n, new ArrayList());
                numPosition.get(n).add(i);
            }
        } 
        return result;
    }
    
    public static int getDistance2(List<Integer> posi){
        int size = posi.size();
    	if(size<3){
            return -1;
        }
        int best = Integer.MAX_VALUE;
   
		int a = posi.get(size-3);
		int b = posi.get(size-2);
		int c = posi.get(size-1);
		best = Math.min(best, Math.abs((a - b)) + Math.abs((b - c)) + Math.abs((c - a)));
        
        return best;   
    }

}
