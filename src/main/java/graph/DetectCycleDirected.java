package graph;

import java.util.List;

public class DetectCycleDirected {

    public boolean detectCycle(List<List<Integer>> adj, int source, boolean[] visited, boolean[] stack){

        stack[source] = true;
        visited[source] = true;
        for(Integer connection:adj.get(source)){
            if(!visited[connection]){
                if(detectCycle(adj, connection, visited,stack)){
                    return true;
                }
            }
            else if(stack[connection]){
                return true;
            }
        }
        stack[source] = false;
        return false;
    }

    public boolean dfsCycleDetect(List<List<Integer>> adj, int V){
        boolean[] visited=new boolean[V];

        boolean[] recSt=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false)
                if(detectCycle(adj,i,visited,recSt)==true)
                    return true;
        }
        return false;
    }
}
