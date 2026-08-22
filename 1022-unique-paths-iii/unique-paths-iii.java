class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol=0;
        int emptyCount = 1;
        for(int r = 0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    startRow = r;
                    startCol = c;
                } else if(grid[r][c] == 0){
                    emptyCount++;
                }
            }
        }
        return dfs(grid, startRow,  startCol, emptyCount);
    }

    private int dfs(int[][] grid, int r, int c, int emptyCount) {
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] < 0) {
            return 0;
        }

        
        if (grid[r][c] == 2) {
            
            return emptyCount == 0 ? 1 : 0;
        }

        grid[r][c] = -1;
    
        int totalPaths = dfs(grid, r + 1, c, emptyCount - 1) +
                         dfs(grid, r - 1, c, emptyCount - 1) + 
                         dfs(grid, r, c + 1, emptyCount - 1) + 
                         dfs(grid, r, c - 1, emptyCount - 1);  
                         
        
        grid[r][c] = 0;

        return totalPaths;
    }
}