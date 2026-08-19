class Solution {

    public boolean isValid(int[][] grid, int r, int c, int n, int exp) {

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != exp) {
            return false;
        }

        if (exp == n * n - 1) {
            return true;
        }

        return isValid(grid, r - 2, c + 1, n, exp + 1) ||
               isValid(grid, r - 1, c + 2, n, exp + 1) ||
               isValid(grid, r + 1, c + 2, n, exp + 1) ||
               isValid(grid, r + 2, c + 1, n, exp + 1) ||
               isValid(grid, r + 2, c - 1, n, exp + 1) ||
               isValid(grid, r + 1, c - 2, n, exp + 1) ||
               isValid(grid, r - 1, c - 2, n, exp + 1) ||
               isValid(grid, r - 2, c - 1, n, exp + 1);
    }

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) {
            return false;
        }
        
        return isValid(grid, 0, 0, grid.length, 0);
    }
}