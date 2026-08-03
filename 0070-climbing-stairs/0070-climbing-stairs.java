class Solution {
    private int helper(int[] dp,int n,int count){
        if(n==0) return count+1;
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n]=helper(dp,n-1,count)+helper(dp,n-2,count);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        return helper(dp,n,0);
    }
}