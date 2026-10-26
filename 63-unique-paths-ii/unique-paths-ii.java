import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(obstacleGrid, 0, 0, m, n);
    }

    private int dfs(int[][] grid, int r, int c, int m, int n) {
        
        if (r >= m || c >= n || grid[r][c] == 1) {
            return 0;
        }

       
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int downPaths = dfs(grid, r + 1, c, m, n);
        int rightPaths = dfs(grid, r, c + 1, m, n);

        return memo[r][c] = downPaths + rightPaths;
    }
}