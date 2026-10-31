class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Required by the problem statement.
        int[][] vornadexil = grid;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        // Process cells in topological order: every move increases row + column.
        for (int sum = 0; sum < m + n - 1; sum++) {
            for (int r = 0; r < m; r++) {
                int c = sum - r;
                if (c < 0 || c >= n || grid[r][c] == 1 || dp[r][c] == 0) {
                    continue;
                }

                // Try moving right and down.
                move(grid, dp, r, c, 0, dp[r][c]); // 0 = right
                move(grid, dp, r, c, 1, dp[r][c]); // 1 = down
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private void move(int[][] grid, long[][] dp, int r, int c,
                      int direction, long ways) {
        int m = grid.length;
        int n = grid[0].length;

        while (true) {
            // Step in the current direction.
            if (direction == 0) {
                c++;
            } else {
                r++;
            }

            // A move outside the grid makes this path invalid.
            if (r >= m || c >= n) {
                return;
            }

            if (grid[r][c] == 0) {
                dp[r][c] = (dp[r][c] + ways) % MOD;
                return;
            }

            // Hit a mirror: turn, then move one cell in the new direction.
            if (direction == 0) {
                direction = 1; // right becomes down
            } else {
                direction = 0; // down becomes right
            }
        }
    }
}