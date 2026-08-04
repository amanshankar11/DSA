class Solution {
    private int helper(int[] dp,int[] nums,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1)return dp[i];
        int cost1=nums[i]+helper(dp,nums,i+1);
        int cost2=nums[i]+helper(dp,nums,i+2);
        return dp[i]=Math.min(cost1,cost2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        int ans=Math.min(helper(dp,cost,0),helper(dp,cost,1));
        return ans;
    }
}