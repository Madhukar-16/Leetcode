import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int[][] dist = new int[n][2];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int start = cur[0];
            int dir = cur[1];
            int d = dist[start][dir];

            // Check whether the current arrangement is sorted.
            boolean sorted = true;

            for (int i = 0; i < n; i++) {
                int idx = (start + (dir == 0 ? i : -i) + n) % n;

                if (nums[idx] != i) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return d;
            }

            // Operation 1: Rotate left by one.
            int nextStart = (start + (dir == 0 ? 1 : -1) + n) % n;

            if (dist[nextStart][dir] == -1) {
                dist[nextStart][dir] = d + 1;
                q.offer(new int[]{nextStart, dir});
            }

            // Operation 2: Reverse the entire array.
            nextStart = (start + (dir == 0 ? -1 : 1) + n) % n;
            int nextDir = 1 - dir;

            if (dist[nextStart][nextDir] == -1) {
                dist[nextStart][nextDir] = d + 1;
                q.offer(new int[]{nextStart, nextDir});
            }
        }

        return -1;
    }
}