/**
 * 1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:
Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */

package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC1695_MaximumErasureValue {
    public static void main(String[] args) {
        int[] arr = {4,2,4,5,6};

        //System.out.println( maximumUniqueSubarray1(arr) );
        System.out.println( maximumUniqueSubarray2(arr) );
    }

    //some test case failing in leet code  - chcek
    public static int maximumUniqueSubarray1(int[] nums) {
        Map<Integer, Integer>  elementIndex = new HashMap<>();
        int[] prefixSum = prefixSumArray(nums);
        int start = 0;
        int end = 0;
        int result = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(elementIndex.containsKey(n)){
                start = elementIndex.get(n)+1;
                result = Math.max(result, prefixSum[end]-prefixSum[start-1]);
            }else{
                end = i;
                int substract = start==0? 0:prefixSum[start-1];
                result = Math.max(result, prefixSum[end]- substract);
            }
            elementIndex.put(n, i);
        }
        return result;
    }

    public static int[] prefixSumArray(int[] arr){
        int [] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        return prefixSum;
    }



    public static int maximumUniqueSubarray2(int[] arr){
        Map<Integer, Integer> eleMap = new HashMap<>();
        int pointer = 0;
        int curSum = 0;
        int result = 0;
        for(int i=0; i<arr.length; i++){
            int n = arr[i];
            if(eleMap.containsKey(n)){
                while (pointer<=eleMap.get(n)){
                    curSum -= arr[pointer++];
                }
            }

            eleMap.put(n, i);
            curSum += n;
            result = Math.max(result, curSum);
        }
        return result;
    }

}
