/**
 * 80. Remove Duplicates from Sorted Array II

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique 
element appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be 
placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first 
k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) 
extra memory.

Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length
int k = removeDuplicates(nums); // Calls your implementation
assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */


package com.example.demo.leet_code;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC80_RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,1,2,3,3};
		
		System.out.println( remove3(arr) );
		
		System.out.println( Arrays.toString(arr) );
	}
	
	//likedHasmap <number, count> then place all elements in the array , separately count the num occurs more than 2  
    public static int remove(int[] nums) {
    	//here used linkedmap becoz problem wants order to be maintained
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0)+1);
        int dupCount = 0; 
        int index = 0;
        for(int key: map.keySet()) {
        	int count = map.get(key);
        	if(count == 1) nums[index++] = key;
        	else {
        		dupCount += count - 2; 
        		nums[index++] = key; 
        		nums[index++] = key; 
        	}
        }
        
        return nums.length-dupCount;
    }
    
    
    //optmized , while building map to check occurrence count , then&there only will continue update the array  
    public static int remove2(int[] nums) {
    	//here used linkedmap becoz problem wants order to be maintained
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int dupCount = 0; 
        int index = 0;
        for(int i=0; i<nums.length; i++) {
        	int key = nums[i];
        	map.put(key, map.getOrDefault(key, 0)+1);
        	int value = map.get(key); 
        	if(value <= 2) {
        		nums[index++] = key;
        	}else {
        		dupCount += 1;
        	}
        }
        
        return nums.length-dupCount;
    }
    
    //optmized2 , instead of map , as array sorted use two var key and count to maintain current aar[i] the count 
    //in leetcode this beats 100%
    public static int remove3(int[] nums) {
    	int key = nums[0];
    	int count = 1; 
        int dupCount = 0; 
        int index = 1;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == key) {
        		count += 1;
        	}else {
        		key = nums[i]; 
        		count = 1; 
        	}
        	
        	if(count <= 2) nums[index++] = key;
        	else dupCount += 1;
        }
        
        return nums.length-dupCount;
    }

}












