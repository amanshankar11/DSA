class Solution {
    private int helper(int[][] dp,int[][] grid,int i,int j){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=helper(dp,grid,i-1,j);
        int left=helper(dp,grid,i,j-1);
        return dp[i][j]= grid[i][j]+Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans=helper(dp,grid,grid.length-1,grid[0].length-1);
        return ans;
    }
}