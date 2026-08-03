class Solution {
    private int helper(int[] dp,int[] nums,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=nums[i]+helper(dp,nums,i+2);
        int notTake=helper(dp,nums,i+1);
        dp[i]=Math.max(take,notTake);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Math.max(helper(dp,nums,0),helper(dp,nums,1));
    }
}