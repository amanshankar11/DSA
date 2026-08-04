class Solution {
    private boolean helper(Boolean[][] dp,int[] nums,int i,int sum,int target){
        if(i>=nums.length || sum>target)return false;
        if(target==sum)return true;
        if(dp[i][sum]!=null)return dp[i][sum];
        boolean pick=helper(dp,nums,i+1,sum+nums[i],target);
        boolean notPick=helper(dp,nums,i+1,sum,target);
        dp[i][sum]=pick||notPick;
        return dp[i][sum];
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int x:nums)total+=x;
        if(total%2!=0) return false;
        int target=total/2;
        Boolean[][] dp=new Boolean[nums.length][target+1];
        Boolean ans=helper(dp,nums,0,0,target);
        return ans;
    }
}