package graph;

import java.util.*;

public class TopologicalSorting {

    /*
    Topological Sorting. (Applies only to directed graph)
                1   4
               / \ / \
              2   3   5
             /   /
             |  /
              6
             This is a directed graph, directions must be intuitive (top down)
           Explanation : 3 is dependent on 1 and 4. Hence 3 should be printed only after 1 & 4.
                         6 is dependent on 2 & 3, Hence 6 should be printed only after 2 & 3.
           Output : [1,4,2,3,5,6] Note: topological sorting is not unique.
    BFS : Here we find the nodes which have zero degree and push them to queue first.
          We also populate a map with every vertex and it's indegrees( No of edges this vertex is receiving)
          In level order traversal, we decrease the map indegree when we come across it by 1.
          But, we push it to queue only when the indegree of a key(adjacent) has reached 0.

    DFS : Here we do the normal dfs traversal, but after processing all the adjacents we push the node to stack.
        By the end of traversal, the stack will contains the topological sort of the graph.

        Why this works: for(every adjacent : vertex)
                        {
                            dfs(vertex) if not visited.
                        }
                        stack.push(vertex).
            As you can see, the push happens only when we've reached bottom nodes and we starting coming up.
            Which means the bottom nodes(nodes with high degree will be executed in the end).
     */

    public void printTopologicalSort(List<List<Integer>> adj){
        Map<Integer, Integer> map = getMapOfIndegrees(adj);
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[adj.size()];
        for(Integer key: map.keySet()){
            if(map.get(key)==0){
                queue.add(key);
            }
        }

        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            System.out.println(vertex+" ");
            visited[vertex] = true;

            for(Integer connection: adj.get(vertex)){
                map.put(connection, map.get(connection)-1);
                if(map.get(connection)==0){
                    queue.add(connection);
                }
            }
        }
    }

    private Map<Integer, Integer> getMapOfIndegrees(List<List<Integer>> adj) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<adj.size(); i++){
            for(Integer connection: adj.get(i)){
                if(map.containsKey(connection)){
                    map.put(connection, map.get(connection)+1);
                }
                else{
                    map.put(connection, 1);
                }
            }
        }

        // incase nodes with zero degrees were not present in adj.
        for(int i=0; i<adj.size(); i++){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
        }
        return map;

    }

    // dfs
    public void topSort(List<List<Integer>> adj, Stack<Integer> topSort, boolean[] visited, int root){

        for(Integer adjacent: adj.get(root)){
            if(!visited[adjacent]){
                visited[adjacent] = true;
                topSort(adj, topSort, visited, root);
            }
        }
        topSort.push(root);
    }

    public Stack<Integer> topSortDfs(List<List<Integer>> adj){
        Stack<Integer> topSort = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++) {
            if(!visited[i]){
                topSort(adj, topSort, visited, i);
            }
        }
        return topSort;
    }



}
