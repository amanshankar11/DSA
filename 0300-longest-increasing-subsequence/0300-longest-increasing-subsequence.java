class Solution {
    // private int helper(int[] nums,int i,int prev,int count,int max){
    //     if(i>=nums.length){
    //         return Math.max(max,count);
    //     }
    //     int pick=0;
    //     if(prev<nums[i]){
    //         pick=helper(nums,i+1,nums[i],count+1,max);
    //     }
    //     int notPick=helper(nums,i+1,prev,count,max);
    //     return Math.max(pick,notPick);
    // }
    private int helper(int[][] dp,int[] nums,int i,int prevIndex){
        if(i>=nums.length) return 0;
        if(dp[i][prevIndex+1]!=-1) return dp[i][prevIndex+1];
        int pick=0;
        if(prevIndex<0 || nums[i]>nums[prevIndex]){
            pick=1+helper(dp,nums,i+1,i);
        }
        int notPick=helper(dp,nums,i+1,prevIndex);
        return dp[i][prevIndex+1]=Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        // int ans=helper(nums,0,Integer.MIN_VALUE,0,Integer.MIN_VALUE);
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=helper(dp,nums,0,-1);
        return ans;
    }
}