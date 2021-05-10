package graph;

import java.util.*;

public class ShortestPathInDirectAcyclicWieghtedGraph {

    /*
              2      3        6
           0---->1---->2--------->3           0 goes to 4, 4 comes to 2 and 5 comes to 1.
           \          /          /
         1  \     2  /          /1
             \      /          /
              \    /          /
                 4 --------->5
                       4

          Using Topological Sorting:
                It works because...
                        * we don't have a loop.
                        * distance of adjacent = distance of vertex + weight(vertex,adjacent)
                        * if any of the new distance becomes lesser than the old one, we update it.
     */
    public void shortestDistance(List<List<Integer>> adj, int source){

        // assuming that the weights are provided this way.
        Map<Pair, Integer> weight = new HashMap<>();

        Set<Integer> set = new HashSet<>();
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        ArrayList<Integer> topSort = new ArrayList<>(new TopologicalSorting().topSortDfs(adj));
        for(Integer vertex: topSort){
            for(Integer adjacent: adj.get(vertex)){
                if(distance[adjacent]>weight.get(new Pair(vertex, adjacent))+distance[vertex]);
            }
        }
    }

    static int minRepeats(String A, String B) {
        // code here
        StringBuilder builder = new StringBuilder(A);
        int count = 0;
        while(builder.toString().contains(B)){
            count++;
            builder.append(A);
        }
        return count;
    }

}

class Pair{
    int vertex;
    int adjacent;

    public Pair(int vertex, int adjacent) {
        this.vertex = vertex;
        this.adjacent = adjacent;
    }
}
