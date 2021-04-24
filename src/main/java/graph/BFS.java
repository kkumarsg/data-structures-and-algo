package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // connected graph, starting from zero always.
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj, Integer root, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        visited[root] = true; // starting from zero.
        queue.add(root);
        bfs.add(root);
        while(!queue.isEmpty()){
            int value = queue.poll();
            for(Integer connection: adj.get(value)){
                if(!visited[connection]){
                    bfs.add(connection);
                    visited[value] = true;
                    queue.add(connection);
                }
            }
        }
        return bfs;
    }

    // disconnected graph
    public void bfsOfDisconnectedGraph(ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited = new boolean[adjList.size()];
        for(int i=0; i<adjList.size(); i++){
            if(!visited[i]){
                bfsOfGraph(adjList, i, visited);
            }
        }
    }


}
