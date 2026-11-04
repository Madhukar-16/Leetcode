import java.util.*;

class Solution {
    int m;
    int[] cntT;
    long[] sumT;

    void update(int i, int dc, long ds) {
        for (; i <= m; i += i & -i) {
            cntT[i] += dc;
            sumT[i] += ds;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] vals = Arrays.stream(nums).distinct().sorted().toArray();
        m = vals.length;
        cntT = new int[m + 1];
        sumT = new long[m + 1];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(vals, nums[i]) + 1;
        }

        int LOG = Integer.highestOneBit(m);
        long[] cost = new long[n - x + 1];
        long total = 0;

        for (int i = 0; i < n; i++) {
            update(rank[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(rank[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                // find median: the ((x+1)/2)-th smallest
                int kth = (x + 1) / 2;
                int pos = 0;
                for (int pw = LOG; pw > 0; pw >>= 1) {
                    if (pos + pw <= m && cntT[pos + pw] < kth) {
                        pos += pw;
                        kth -= cntT[pos];
                    }
                }
                long med = vals[pos];
                int r = pos + 1;

                // prefix count and sum up to rank r
                long cntLE = 0, sumLE = 0;
                for (int j = r; j > 0; j -= j & -j) {
                    cntLE += cntT[j];
                    sumLE += sumT[j];
                }
                cost[i - x + 1] = med * cntLE - sumLE
                        + (total - sumLE) - med * (x - cntLE);
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int j = 1; j <= k; j++) Arrays.fill(dp[j], INF);

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] < INF) {
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - x] + cost[i - x]);
                }
            }
        }
        return dp[k][n];
    }
}