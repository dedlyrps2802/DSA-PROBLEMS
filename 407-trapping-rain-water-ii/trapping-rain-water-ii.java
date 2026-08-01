import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Min-Heap based on cell height
        // Storing int[] {row, col, height}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        // Step 1: Add all outer boundaries to the Min-Heap
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
        }
        for (int j = 1; j < n - 1; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
        }

        int trappedWater = 0;
        // 4 directions: Up, Down, Left, Right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Process cells starting from the lowest boundary
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0];
            int c = cell[1];
            int boundaryHeight = cell[2];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check if neighbor is within bounds and not visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    
                    // If neighbor is shorter, it traps water
                    if (heightMap[nr][nc] < boundaryHeight) {
                        trappedWater += boundaryHeight - heightMap[nr][nc];
                    }
                    
                    // Push the neighbor into PQ with updated boundary height
                    pq.offer(new int[]{nr, nc, Math.max(boundaryHeight, heightMap[nr][nc])});
                }
            }
        }

        return trappedWater;
    }
}