/**
 * 1320. Minimum Distance to Type a Word Using Two Fingers

You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter is located at some coordinate.

For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate (0, 1), the letter 'P' is located 
at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
Given the string word, return the minimum total distance to type such string using only two fingers.
The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.
Note that the initial positions of your two fingers are considered free so do not count towards your total distance, also your two fingers 
do not have to start at the first letter or the first two letters.

Example 1:
Input: word = "CAKE"
Output: 3
Explanation: Using two fingers, one optimal way to type "CAKE" is: 
Finger 1 on letter 'C' -> cost = 0 
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2 
Finger 2 on letter 'K' -> cost = 0 
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1 
Total distance = 3

Example 2:
Input: word = "HAPPY"
Output: 6
Explanation: Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -> cost = 0
Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6
 

Constraints:
2 <= word.length <= 300
word consists of uppercase English letters.
 */


package com.example.demo.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LC1320_MinimumDistanceTypeWordUsingTwoFingers {
	
	public static void main(String[] args) {
		System.out.println( getDistance('A', 'Y') );
		System.out.println( removeIndex("CAKE", 0, 1) );
		
		System.out.println( minimumDistance1("CAKE") );
		System.out.println( minimumDistance1("HAPPY") );
	}
	
	
	//TLE - 24 / 55 testcases passed when used recur   || memo giving wrong ans 
    public static int minimumDistance1(String word) {
    	if(word.length() <= 2) return 0;
        Map<Character,Map<Character,Integer>> charDistance = charToCharDistance();
        int result = Integer.MAX_VALUE;
        for(int i=1; i<word.length(); i++) {
        	String temp = word; 
        	temp = removeIndex(temp, 0, i);
        	
        	//int recur = recur(word.charAt(0), word.charAt(i), temp, charDistance);
        	int memo = memo(word.charAt(0), word.charAt(i), temp, charDistance, new HashMap<>());
        	
        	result = Math.min(result, memo);
        }
        return result;
    }
    
    //here left char in left finger and right in right finger , will use pick unpick 
    public static int recur(char left, char right, String w, Map<Character,Map<Character,Integer>> charDistance) {
    	if(w.length() == 0 || w==null ) return 0;
    	
    	char pick = w.charAt(0); 
    	//int res = Integer.MAX_VALUE; 
    	//min of left pick and right pick 
    	return Math.min( recur(pick, right, w.length()==1? "": w.substring(1), charDistance) + charDistance.get(left).get(pick) ,
    			recur(left, pick, w.length()==1? "": w.substring(1), charDistance) + charDistance.get(right).get(pick) );
    	
    }
    
   //here left char in left finger and right in right finger , will use pick unpick 
    public static int memo(char left, char right, String w, Map<Character,Map<Character,Integer>> charDistance, Map<String, Integer> memo) {
    	if(w.length() == 0 || w==null ) return 0;
    	
    	String key = left + "|" + right + "|" + w;
    	if (memo.containsKey(key)) {
            return memo.get(key);
        }

    	
    	char pick = w.charAt(0); 
    	//int res = Integer.MAX_VALUE; 
    	//min of left pick and right pick 
    	int leftUse =  memo(pick, right, w.length()==1? "": w.substring(1), charDistance, memo) + charDistance.get(left).get(pick);
    	int rightUse = memo(left, pick, w.length()==1? "": w.substring(1), charDistance, memo) + charDistance.get(right).get(pick);
    	
    	int res = Math.min(leftUse, rightUse);
    	memo.put(key, res);
    	
    	return res;
    }
    
    public static Map<Character, Map<Character, Integer>> charToCharDistance(){
    	Map<Character, Map<Character, Integer>> charToChar = new HashMap<>(); 
    	for(int i='A'; i<='Z'; i++) {
    		char ch1 = (char) i;
    		Map<Character, Integer> charDis = new HashMap<>();
    		for(int j='A'; j<='Z'; j++) {
    			char ch2 = (char) j;
    			charDis.put(ch2, getDistance(ch1, ch2));
    		}//INER FOR END	
    		charToChar.put(ch1, charDis);
    	}
    	return charToChar;
    }
    
    //chaqr matrix has 6 col [0-5]
    public static int getDistance(char ch1, char ch2) {
    	return 	 Math.abs( ((ch1-'A')/6) - ((ch2-'A')/6) ) +  Math.abs( ((ch1-'A')%6) - ((ch2-'A')%6) );
    }
    
    public static String removeIndex(String w, int i, int j) {
    	String result = "";
    	for(int k=0; k<w.length(); k++) {
    		if(k!=i && k!=j) {
    			result += w.charAt(k);
    		}
    	}
    	return result;
    }
    
    
    
    //optimal dp 
    public static int minimumDistance3(String word) {
        Integer[][][] dp = new Integer[word.length()][27][27];
        return solve(word, 0, 26, 26, dp);
    }

    // 26 means "finger not placed yet"
    private static int solve(String word, int index, int left, int right, Integer[][][] dp) {
        if (index == word.length()) return 0;

        if (dp[index][left][right] != null) {
            return dp[index][left][right];
        }

        int curr = word.charAt(index) - 'A';

        // Move left finger
        int moveLeft = getDist(left, curr) + solve(word, index + 1, curr, right, dp);

        // Move right finger
        int moveRight = getDist(right, curr) + solve(word, index + 1, left, curr, dp);

        return dp[index][left][right] = Math.min(moveLeft, moveRight);
    }

    // Distance calculation
    private static int getDist(int from, int to) {
        if (from == 26) return 0; // finger not placed

        int x1 = from / 6, y1 = from % 6;
        int x2 = to / 6, y2 = to % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    
}
