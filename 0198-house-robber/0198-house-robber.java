class Solution {
    private int helper(int[] nums,int[] dp,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=nums[i]+helper(nums,dp,i+2);
        int notTake=helper(nums,dp,i+1);
        return dp[i]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(helper(nums,dp,0),helper(nums,dp,1));
    }
}