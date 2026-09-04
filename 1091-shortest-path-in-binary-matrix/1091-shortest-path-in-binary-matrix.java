class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] directions={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        while(!q.isEmpty()) {
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];
            int steps=curr[2];

            if(i==n-1 && j==n-1) {
                return steps;
            }

            for(int[] dir:directions) {
                int ni=i+dir[0];
                int nj=j+dir[1];

                if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]==0) {
                    grid[ni][nj] = 1;
                    q.offer(new int[]{ni, nj, steps + 1});
                }
            }
        }
        return -1;
    }
}