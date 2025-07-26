/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two 
different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one 
direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges 
changed.

It's guaranteed that each city can reach city 0 after reorder.


Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:
2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
 */


package com.example.demo.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LOC1466_ReorderRoutesToMakeAllPathsLeadTheCityZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6, connections[][] = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
		
		System.out.println( minReorder1(n, connections) );

	}

	public static int minReorder1(int n, int[][] connections) {
        List<List<Integer>>[] graphArray = getGraph(n, connections);
        List<List<Integer>> outGoingGraph = graphArray[0];
        List<List<Integer>> inComingGraph = graphArray[1];

        int[] visited = new int[n];

        return DFS(0, outGoingGraph, inComingGraph, visited);
    }

    //here return type List<>array where arr[0] = outGoingGraph, arr[1] = incomingGraph
    public static List<List<Integer>>[] getGraph(int totalNode, int[][] connection){
        List<List<Integer>> outGoingGraph = new ArrayList<>();
        List<List<Integer>> inComingGraph = new ArrayList<>();
        //initialize the inner list
        for(int i=0; i<totalNode; i++){
            outGoingGraph.add(new ArrayList<>());
            inComingGraph.add(new ArrayList<>());
        }

        //traverse through connection and create the graphs
        for(int[] arr : connection){
            //here connection is arr[0] -> arr[1]
            int u = arr[0], v= arr[1];
            outGoingGraph.get(u).add(v);
            inComingGraph.get(v).add(u);
        }

        List<List<Integer>>[] result =  new List[2];
        result[0] = outGoingGraph;
        result[1] = inComingGraph;
        return result;
    }


    public static int DFS(int vertex, List<List<Integer>> outGraph, List<List<Integer>> inGraph, int[] visited){
        visited[vertex] = 1;

        int directionChange = 0;
        //chcek for out graph where direction need to change, to make all path lead to ZERO
        for(int neighbor : outGraph.get(vertex)){
            if(visited[neighbor] == 0){
                directionChange += 1 + DFS(neighbor, outGraph, inGraph, visited);
            }
        }

        //check for incoming , here direction already inside so, just move to neighbor to make sure neighbor's neighbor direction is inside or not 
        for(int neighbor : inGraph.get(vertex)){
            if(visited[neighbor] == 0){
                directionChange += DFS(neighbor, outGraph, inGraph, visited);
            }
        }

        return directionChange;
     }//DFS end
	
}














