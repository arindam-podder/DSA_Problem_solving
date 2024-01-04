/*
 *  Cycle in Directed Graph

Problem Description
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there
is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:
The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 105
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if cycle is present else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.
 */


package com.example.demo.sclr_code.graphs;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		

	}

}


/*
 *public class Solution {
    int[] visited;
    int[] path;

    public int dfs(int node, ArrayList<ArrayList<Integer>> B,int[] visited,int[] path) {
            visited[node]=1;
            path[node]=1;
            for(int i : B.get(node))
            {
                if(path[i] == 1)
                {
                    return 1;
                }
                if(visited[i] == 0)
                {
                    if(dfs(i,B,visited,path) == 1)
                    {
                     //   System.out.println("Inside function loop");
                        return 1;
                    }
                }
            }
            path[node]=0;
            return 0;
    }
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if(B.size() == 1) // For 1 size, there is no cyclic
        {
            return 0;
        }
        visited = new int[A+1];
        path = new int[A+1];
        // Create adjacency List to store the element with respect to Nodes
        ArrayList<ArrayList<Integer>> list=new  ArrayList<ArrayList<Integer>>();
       
        for(int i=0;i<=A;i++)
        {
            list.add(new ArrayList<Integer>()); // initialing A number of nodes
        }
       
        for(int i=0;i<B.size();i++)
        {
            list.get(B.get(i).get(0)).add(B.get(i).get(1)); // creating adjacency list
        }
   
        for(int i=1;i<=A;i++)
        {
            if(visited[i] == 0)
            {
                if(dfs(i,list,visited,path) == 1)
                {
                    return 1;
                }
            }
        }
        return 0;
    }
} 
 */
