package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirected
{

    public boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfsList.add(0);
        visited[0] = true;


        for (int i = 0; i < adj.size(); i++){
            if (!visited[i]) {
                if(dfsPopulate(dfsList, i, adj, visited,-1)){
                    return true;
                }
            }

        }
        return false;
    }


    public boolean dfsPopulate(List<Integer> dfs, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited,int parent)
    {

        for(Integer value: adj.get(v)){
            if(!visited[value]){
                dfs.add(value);
                visited[value] = true;
                if(dfsPopulate(dfs, value, adj, visited,value)){
                    return true;
                }
            }
            if(value!=parent){
                return true;
            }
        }
        return false;
    }
}
