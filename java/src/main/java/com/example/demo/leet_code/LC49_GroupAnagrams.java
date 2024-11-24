/*
 * leetcode 49
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49_GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> resulList = groupAnagram(Arrays.asList("eat","tea","tan","ate","nat","bat"));
		
		System.out.println( resulList );
	}
	
	public static ArrayList<ArrayList<String>> groupAnagram(List<String> list){    //leetcode 49		
		HashMap<String, ArrayList<Integer>> hm = new HashMap<>(); 
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			s = new String(charArray);
			if(hm.containsKey(s)) {
				hm.get(s).add(i); 
			}else{
				ArrayList<Integer> lst = new ArrayList<>(); 
				lst.add(i);
				hm.put(s, lst); 
			}
		}
		
		ArrayList<ArrayList<String>> ans = new ArrayList<>(); 
		for(String key : hm.keySet()) {
			ArrayList<String> temp = new ArrayList<>(); 
			for(Integer i : hm.get(key)) {
				temp.add(list.get(i));
			}
			ans.add(temp); 
		}
		return ans; 
	}

}
