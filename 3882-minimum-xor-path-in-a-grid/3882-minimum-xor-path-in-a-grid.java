import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        BitSet[][] dp = new BitSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new BitSet(1024);

                if (i == 0 && j == 0) {
                    dp[i][j].set(grid[i][j]);
                    continue;
                }

                if (i > 0) {
                    addXors(dp[i - 1][j], dp[i][j], grid[i][j]);
                }

                if (j > 0) {
                    addXors(dp[i][j - 1], dp[i][j], grid[i][j]);
                }
            }
        }

        return dp[m - 1][n - 1].nextSetBit(0);
    }

    private void addXors(BitSet previous, BitSet current, int value) {
        for (int xor = previous.nextSetBit(0);
             xor >= 0;
             xor = previous.nextSetBit(xor + 1)) {
            current.set(xor ^ value);
        }
    }
}