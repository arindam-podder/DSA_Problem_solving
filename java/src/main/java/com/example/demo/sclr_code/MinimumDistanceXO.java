/*
Given a string A which contains only three characters {'x', 'o', '.'}.

Find minimum possible distance between any pair of 'x' and 'o' in the string.

Distance is defined as the absolute difference between the index of 'x' and 'o'.

NOTE: If there is no such pair return -1
*/


package com.example.demo.sclr_code;

public class MinimumDistanceXO {

	
	public static void main(String[] args) {
		System.out.println(solve("x...o.x...o"));
	}
	
	
	
	
	 public static int solve(String A) {
	        int dis = Integer.MAX_VALUE, startpos = Integer.MAX_VALUE;
	        if(!A.contains("x") || !A.contains("o"))
	        {
	            return -1;
	        }
	        else
	        {
	            for (int i = 0; i < A.length(); i++)
	            {
	                if (A.charAt(i) == 'x' || A.charAt(i) == 'o')
	                {
	                    if (startpos == Integer.MAX_VALUE)
	                    {
	                        startpos = i;
	                        continue;
	                    }
	                    if (A.charAt(startpos) == 'x' && A.charAt(i) == 'x' || A.charAt(startpos) == 'o' && A.charAt(i) == 'o')
	                    {
	                        startpos = i;
	                    }
	                    if (A.charAt(startpos) == 'o' && A.charAt(i) == 'x' || A.charAt(startpos) == 'x' && A.charAt(i) == 'o')
	                    {
	                        if (i - startpos < dis)
	                        {
	                            dis = i - startpos;
	                        }
	                        startpos = i;
	                    }
	                }
	            }
	        }
	        return dis == Integer.MAX_VALUE ? -1 : dis;
	    }
}
