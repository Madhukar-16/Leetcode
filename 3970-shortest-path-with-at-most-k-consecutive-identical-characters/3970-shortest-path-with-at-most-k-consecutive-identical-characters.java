import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // State: {cost, node, consecutive matching-label count}
        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(state -> state[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] state = pq.poll();
            long cost = state[0];
            int node = (int) state[1];
            int run = (int) state[2];

            if (cost != dist[node][run]) {
                continue;
            }
            if (node == n - 1) {
                return (int) cost;
            }

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int nextRun = labels.charAt(node) == labels.charAt(next) ? run + 1 : 1;

                if (nextRun > k) {
                    continue;
                }

                long nextCost = cost + edge[1];
                if (nextCost < dist[next][nextRun]) {
                    dist[next][nextRun] = nextCost;
                    pq.offer(new long[]{nextCost, next, nextRun});
                }
            }
        }

        return -1;
    }
}