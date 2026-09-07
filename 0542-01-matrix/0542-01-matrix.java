class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Put all 0s into queue
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    // Mark 1s as unvisited
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];

            for (int[] dir : directions) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < mat.length &&
                    nj >= 0 && nj < mat[0].length &&
                    mat[ni][nj] == -1) {

                    mat[ni][nj] = mat[i][j] + 1;

                    q.offer(new int[]{ni, nj});
                }
            }
        }

        return mat;
    }
}