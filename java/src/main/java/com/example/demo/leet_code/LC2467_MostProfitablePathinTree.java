/**
 * 2467. Most Profitable Path in a Tree

There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 
2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between 
nodes ai and bi in the tree.
At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] 
represents:

the price needed to open the gate at node i, if amount[i] is negative, or,
the cash reward obtained on opening the gate at node i, otherwise.
The game goes on as follows:

Initially, Alice is at node 0 and Bob is at node bob.
At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, 
while Bob moves towards node 0.
For every node along their path, Alice and Bob either spend money to open the gate at that node, 
or accept the reward. Note that:
If the gate is already open, no price will be required, nor will there be any cash reward.
If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. 
In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly,
 if the reward at the gate is c, both of them receive c / 2 each.
If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. 
Note that these events are independent of each other.
Return the maximum net income Alice can have if she travels towards the optimal leaf node.

 

Example 1:
Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
Output: 6
Explanation: 
The above diagram represents the given tree. The game goes as follows:
- Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
  Alice's net income is now -2.
- Both Alice and Bob move to node 1. 
  Since they reach here simultaneously, they open the gate together and share the reward.
  Alice's net income becomes -2 + (4 / 2) = 0.
- Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
  Bob moves on to node 0, and stops moving.
- Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
Now, neither Alice nor Bob can make any further moves, and the game ends.
It is not possible for Alice to get a higher net income.

Example 2:
Input: edges = [[0,1]], bob = 1, amount = [-7280,2350]
Output: -7280
Explanation: 
Alice follows the path 0->1 whereas Bob follows the path 1->0.
Thus, Alice opens the gate at node 0 only. Hence, her net income is -7280. 
 

Constraints:
2 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges represents a valid tree.
1 <= bob < n
amount.length == n
amount[i] is an even integer in the range [-104, 104].
 */




package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC2467_MostProfitablePathinTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0,1}, {1,2}, {1,3}, {3,4}};
		int bobPosi = 3;
		int[] amount = {-2,4,2,-4,6};
		
		System.out.println( mostProfitablePathFind(edges, bobPosi, amount) );
		
	}
	
	public static int mostProfitablePathFind(int[][] edges, int bob, int[] amount) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<amount.length; i++) adj.add(new ArrayList<>());
		for(int[] a : edges) {
			int u=a[0]; 
			int v=a[1];
			adj.get(u).add(v); 
			adj.get(v).add(u); 
		}
		List<Integer> bobpath = new ArrayList<>(); 
		bobPath(bob, adj, Integer.MAX_VALUE, bobpath);
		int bobPathSize = bobpath.size();
		//till half reduce amount zero beczuse bob will handle that 
		for(int i=0; i<bobPathSize/2; i++) amount[bobpath.get(i)] = 0;
		//now if bobPathSize is odd the bobPathSize/2 posi will become 0 else shared the value 
		if(bobPathSize%2 == 1) amount[bobpath.get(bobPathSize/2)] = 0;
		else amount[bobpath.get(bobPathSize/2)] /= 2;
		 
		 return maxProfit(0, adj, Integer.MAX_VALUE, amount); 
	 }
	 
	 
	 //find bob path nodes - keep in arr 
	 public static boolean bobPath(int bobPosi, List<List<Integer>> adj, int parent, List<Integer> path) {
		 if(bobPosi == 0) {
			 return true; 
		 }
		 path.add(bobPosi);
		 
		 List<Integer> neighbourList = adj.get(bobPosi);
		 for(int i=0; i<neighbourList.size(); i++) {
			 if(neighbourList.get(i) != parent && bobPath(neighbourList.get(i), adj, bobPosi, path)) {
				 return true;
			 }
		 }
		 
		 //back track
		 path.remove(path.size()-1);
		 return false;
	 }
	 
	 
	 public static int maxProfit(int posi, List<List<Integer>> adj, int parent, int[] amount) {
		 int maxIncome = Integer.MIN_VALUE;
	        for (int nbr : adj.get(posi)) {
	            if (nbr != parent) {
	                int income = maxProfit(nbr, adj, posi, amount);
	                if (income + amount[posi] > maxIncome) {
	                    maxIncome = income + amount[posi];
	                }
	            }
	        }
	        return maxIncome == Integer.MIN_VALUE ? amount[posi] : maxIncome;
	 }
	 
	 

}

















