class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    spread(i, j, grid, 2);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                min = Math.max(min, grid[i][j]);
            }
        }

        return min - 2;
    }

    private void spread(int i, int j, int[][] grid, int t) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        if (j < 0 || i < 0 || i >= m || j >= n || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < t)) {
            return;
        } 
        grid[i][j] = t;  
        spread(i + 1, j, grid, t + 1);
        spread(i - 1, j, grid, t + 1);
        spread(i, j + 1, grid, t + 1);
        spread(i, j - 1, grid, t + 1);
    }
}