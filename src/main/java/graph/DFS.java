package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {


    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfsList.add(0);
        visited[0] = true;
        dfsPopulate(dfsList, 0, adj, visited);
        return dfsList;
    }


    public void dfsPopulate(List<Integer> dfs, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {

        for(Integer value: adj.get(v)){
            if(!visited[value]){
                dfs.add(value);
                visited[value] = true;
                dfsPopulate(dfs, value, adj, visited);
            }
        }
    }
}
