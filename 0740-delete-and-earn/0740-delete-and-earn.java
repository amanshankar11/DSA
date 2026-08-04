class Solution {
    // private int[] updateArray(int[] nums,int lastPoint){
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]+1==lastPoint || nums[i]-1==lastPoint){
    //             nums[i]=0;
    //         }
    //     }
    //     return nums;
    // }
    // private int helper(int[] nums,int i,int lastPoint,int earn){
    //     while(i<nums.length && nums[i]==0)i++;
    //     if(i>=nums.length)return earn;
    //     if(nums[i]+1==lastPoint || nums[i]-1==lastPoint){
    //         nums=updateArray(nums,lastPoint);
    //     }
    //     int pick=helper(nums,i+1,nums[i],earn+nums[i]);
    //     int notPick=helper(nums,i+1,lastPoint,earn);
    //     return Math.max(pick,notPick);
    // }
    private int helper(int[] dp,int[] nums,int i){
        if(i>=nums.length)return 0;
        if(dp[i]!=0) return dp[i];
        int pick=nums[i]+helper(dp,nums,i+2);
        int notPick=helper(dp,nums,i+1);

        return dp[i]=Math.max(pick,notPick);
    }

    public int deleteAndEarn(int[] nums) {
        int max=nums[0];
        for(int i:nums){
            if(max<i) max=i;
        }
        int[] count=new int[max+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]+=nums[i];
        }
        int[] dp=new int[max+1];
        int ans=helper(dp,count,0);
        return ans;
    }
}