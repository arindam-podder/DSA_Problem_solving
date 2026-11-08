/**
 * 347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]


Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class LC347_TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1,2,3,1,3,2}; int k = 2;
		
		System.out.println( Arrays.toString( topKFrequent1(nums, k) ));
		
	}
	
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
        	int ele = nums[i];
        	map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        List<Entry<Integer,Integer>> collect = map.entrySet().stream()
        	.sorted((e1,e2) -> Integer.compare(e2.getValue(), e1.getValue())).collect(Collectors.toList());
        
        int[] res = new int[k]; 
        for(int i=0; i<k; i++) {
        	res[i] = collect.get(i).getKey(); 
        }
        
        
        return res;
    }
	
    
    
}
