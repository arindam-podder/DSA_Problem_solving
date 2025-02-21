/**
 * 1079. Letter Tile Possibilities

You have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1
 
Constraints:
1 <= tiles.length <= 7
tiles consists of uppercase English letters.

 */


package com.example.demo.leet_code;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC1079_LetterTilePossibilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tiles = "AAABBC";
		
		System.out.println( totalPossibilities(tiles) );

	}
	
	public static int totalPossibilities(String tiles) {
        Map<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<tiles.length(); i++) {
        	map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0)+1 );
        }
		
		return backtrack(map);
    }
	
	public static int backtrack(Map<Character, Integer> counter) {
		int res = 0; 
		for(Character key: counter.keySet()) {
			if(counter.get(key) > 0) {
				counter.put(key, counter.get(key)-1);
				res += 1 + backtrack(counter);
				//bacxktrack 
				counter.put(key, counter.get(key)+1);
				
			}
		}
		return res;
	}
	

}
