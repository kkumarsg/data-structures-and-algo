package graph;

public class NoOfIslands {

    /*
      Input: grid = [
                  ["1","1","0","0","0"],
                  ["1","1","0","0","0"],
                  ["0","0","1","0","0"],
                  ["0","0","0","1","1"]
                    ]
        Output: 3
     */
    public int numIslands(char[][] grid)
    {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!visited[i][j] && grid[i][j]=='1')
                    islands += noOfIslands(grid, i, j, visited);
            }
        }
        return islands;
    }

    /*
            (i-1,j-1)   (i-1,j)    (i-1,j+1)
            (i,j-1)     Element    (i,j+1)
            (i+1,j-1)   (i+1,j)    (i+1,j+1)
     */

    // we are considering here that a person can move in all 8 directions.
    // remove last 4 conditions if you want to ignore diagonal conditions.
    public int noOfIslands(char[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        if(i<grid.length && j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1])
            noOfIslands(grid, i, j+1, visited);
        if(i+1<grid.length && j<grid[0].length && grid[i+1][j]=='1' && !visited[i+1][j])
            noOfIslands(grid, i+1, j, visited);
        if(i-1<grid.length && i-1>=0 && j<grid[0].length && grid[i-1][j]=='1' && !visited[i-1][j]) {
            noOfIslands(grid, i-1, j, visited);
        }
        if(i<grid.length && j-1>=0 && j<grid[0].length && grid[i][j-1]=='1' && !visited[i][j-1]) {
            noOfIslands(grid, i, j-1, visited);
        }

        // for diagonal traversals.
        if(i<grid.length && i-1>=0 && j-1>=0 && j<grid[0].length && grid[i-1][j-1]=='1' && !visited[i-1][j-1]) {
            noOfIslands(grid, i-1, j-1, visited);
        }
        if(i-1<grid.length && i-1>=0 && j+1<grid[0].length && grid[i-1][j+1]=='1' && !visited[i-1][j+1]) {
            noOfIslands(grid, i-1, j+1, visited);
        }
        if(i+1<grid.length && j+1<grid[0].length && grid[i+1][j+1]=='1' && !visited[i+1][j+1]) {
            noOfIslands(grid, i+1, j+1, visited);
        }
        if(i+1<grid.length && j-1<grid[0].length && j-1>=0 && grid[i+1][j-1]=='1' && !visited[i+1][j-1]) {
            noOfIslands(grid, i+1, j-1, visited);
        }
        return 1;
    }
}
