/**
 * 2570. Merge Two 2D Arrays by Summing Values

You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. 
If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.

Example 1:
Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.

Example 2:
Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 
Constraints:
1 <= nums1.length, nums2.length <= 200
nums1[i].length == nums2[j].length == 2
1 <= idi, vali <= 1000
Both arrays contain unique ids.
Both arrays are in strictly ascending order by id.

 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2570_MergeTwo2DArraysBySummingValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{2,4}, {3,6}, {5,5}}, arr2 = {{1,3}, {4,3}};

		int[][] mergeArrays1 = mergeArrays1(arr1, arr2);
		
		for(int[] a : mergeArrays1) System.out.println(Arrays.toString(a));
	}
	
	
    public static int[][] mergeArrays1(int[][] arr1, int[][] arr2) {
        List<int[]> resultList = new ArrayList<>();
        int p1 = 0; 
        int p2 = 0; 
        while(p1<arr1.length && p2<arr2.length) {
        	if(arr1[p1][0] == arr2[p2][0]) {
        		int sum = arr1[p1][1] + arr2[p2][1];
        		resultList.add(new int[] {arr1[p1][0], sum});
        		p1++; 
        		p2++;
        	}else if(arr1[p1][0] < arr2[p2][0]) {
        		resultList.add( new int[] {arr1[p1][0], arr1[p1][1]} );
        		p1++;
        	}else {
        		resultList.add( new int[] {arr2[p2][0], arr2[p2][1]} );
        		p2++;
        	}
        }
        //add the pendings 
        while(p1<arr1.length) {
        	resultList.add( new int[] {arr1[p1][0], arr1[p1][1]} );
    		p1++;
        }
        while(p2<arr2.length) {
        	resultList.add( new int[] {arr2[p2][0], arr2[p2][1]} );
    		p2++;
        }
        
        //list to arr 
        int[][] res = new int[resultList.size()][2];
        for(int i=0; i<resultList.size(); i++) {
        	res[i] = new int[]{resultList.get(i)[0], resultList.get(i)[1]}; 
        }
        return res;
    }

}



