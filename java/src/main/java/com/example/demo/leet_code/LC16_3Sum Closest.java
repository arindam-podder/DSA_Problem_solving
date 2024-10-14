/**
16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is 
closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/

public class LC16_3Sum Closest {

  
  
    public int threeSumClosest(int[] nums, int target) {
        return findThreeSumClosest(nums, target);
    }

    public static int findThreeSumClosest(int[] arr, int target) {
        Arrays.sort(arr); 
		int resultSum = arr[0] + arr[1] + arr[2]; 
		int minDiff = Math.abs(resultSum - target);
		for(int fix=0; fix<arr.length-2; fix++){
			int l=fix+1; 
			int r=arr.length-1; 

			while(l<r){
				int currentSum = arr[fix] + arr[l] + arr[r]; 

				if(currentSum == target ){
					return currentSum; 
				}

			 	if(currentSum < target){
					l++;
				}else{
					r--;
				}

				//logic to chek close diff 
				int curDiff = Math.abs(currentSum-target);
				if(curDiff < minDiff){
					minDiff = curDiff; 
					resultSum = currentSum;
				}
			}
		}
		return resultSum;
    }
}



