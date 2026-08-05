class Solution {
    private int helper(int[] dp,int[] coins,int i,int target){
        if(target<0) return Integer.MAX_VALUE;
        if(target==0) return 0;
        int minCoin=Integer.MAX_VALUE;
        if(dp[target]!=-1)return dp[target];

        for(int k=0;k<coins.length;k++){
            int take=helper(dp,coins,k,target-coins[k]);
            if(take!=Integer.MAX_VALUE){
                minCoin=Math.min(minCoin,1+take);
            }
        }
        return dp[target]=minCoin;
    }
    public int coinChange(int[] coins, int amount) {
        // if(coins.length==1 && coins[0]<amount) return -1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int coin=helper(dp,coins,0,amount);
        return coin==Integer.MAX_VALUE?-1:coin;
    }
}