class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int fresh = 0;

        // Add all rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {

            // All oranges currently in queue
            // act during the same minute
            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                for (int[] dir : directions) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < grid.length &&
                        nj >= 0 && nj < grid[0].length &&
                        grid[ni][nj] == 1) {

                        // Fresh -> Rotten
                        grid[ni][nj] = 2;

                        fresh--;

                        q.offer(new int[]{ni, nj});
                    }
                }
            }

            minutes++;
        }

        // Some fresh oranges could not be reached
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}