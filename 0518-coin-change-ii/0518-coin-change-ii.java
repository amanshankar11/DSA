class Solution {
    private int helper(int[][] dp,int[] coins,int i,int target){
        if(target==0) return 1;
        if(i>=coins.length) return 0;
        if(target<0) return 0;
        if(dp[i][target]!=-1)return dp[i][target];
        int pick=helper(dp,coins,i,target-coins[i]);
        int notPick=helper(dp,coins,i+1,target);

        return dp[i][target]=pick+notPick;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);;
        int ways=helper(dp,coins,0,amount);
        return ways;
    }
}