package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {

    public void populateShortestPathFromSource(int source, List<List<Integer>> adj, int[] distance, boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        distance[source] = 0;
        while(!queue.isEmpty()){

            Integer vertex = queue.poll();
            System.out.println(vertex);
            for(Integer adjacent: adj.get(vertex)){
                if (!visited[adjacent]) {
                    queue.add(adjacent);
                    visited[adjacent] = true;
                    distance[adjacent] = distance[vertex]+1;
                }
            }

        }

    }

    public int[] getShortestPathFromSource(List<List<Integer>> adj, int source){

        boolean[] visited = new boolean[adj.size()];
        int[] distance = new int[adj.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);

        populateShortestPathFromSource(source, adj, distance,visited);

        return distance;
    }



}
