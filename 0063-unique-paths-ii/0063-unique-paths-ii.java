class Solution {
    private int helper(int i,int j,int[][] dp,int[][] grid){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        
        int right=helper(i,j+1,dp,grid);
        int down=helper(i+1,j,dp,grid);
        return dp[i][j]=right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return helper(0,0,dp,obstacleGrid);
    }
}