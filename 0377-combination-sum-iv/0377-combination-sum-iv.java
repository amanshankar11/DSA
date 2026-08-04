class Solution {
    // private int helper(int[] nums,int i,int sum,int count,int target){
    //     if(i>=nums.length)return count=0;
    //     if(sum==target) return count+=1;
    //     int check=helper(nums,i+1,sum+nums[i],count,target);
    //     int again=helper(nums,i-1,sum-nums[i],count,target);
    //     return check+again;
    // }
     private int helper(int[] dp,int[] nums, int target) {
        if(target==0) {
            return 1;
        }
        if(target<0) {
            return 0;
        }
        if(dp[target]!=-1) return dp[target];
        int count=0;
        for(int i=0;i<nums.length;i++) {
            count+=helper(dp,nums,target-nums[i]);
        }
        return dp[target]=count;
    }
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        Arrays.fill(dp,-1);
        int ans=helper(dp,nums,target);
        return ans;
    }
}