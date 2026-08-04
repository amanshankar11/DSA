class Solution {
    private int helper(int[] dp,int[] nums,int index,int len){
        if(index>=len) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick=nums[index]+helper(dp,nums,index+2,len);
        int notPick=helper(dp,nums,index+1,len);
        dp[index]=Math.max(pick,notPick);
        return dp[index];
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        int[] dp2=new int[nums.length+1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        if(nums.length==1) return nums[0];
        int ans=Math.max(helper(dp,nums,0,nums.length-1),helper(dp2,nums,1,nums.length));
        return ans;
    }
}