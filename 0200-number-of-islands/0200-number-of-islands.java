class Solution {
    private final int[] dRow = {1, -1, 0, 0};
    private final int[] dCol = {0, 0, -1, 1};
    
    public int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    island++;
                    dfs(grid, vis, n, m, i, j);
                }
            }
        }
        return island;
    }
    
    private void dfs(char[][] grid, int[][] vis, int n, int m, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || vis[row][col] == 1) {
            return;
        }
        
        vis[row][col] = 1;
        
        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
                dfs(grid, vis, n, m, nRow, nCol);
            }
        }
    }
}