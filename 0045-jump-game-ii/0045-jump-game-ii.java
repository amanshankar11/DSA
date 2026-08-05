class Solution {
    private int helper(int[] dp,int[] nums,int i){
        if(i>=nums.length)return Integer.MAX_VALUE;
        if(i==nums.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=nums[i];k++){
            if(i+k<nums.length){
                int count=helper(dp,nums,k+i);
                if(count!=Integer.MAX_VALUE){
                    min=Math.min(min,1+count);
                }
            }
        }
        return dp[i]=min;
    }
    public int jump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans=helper(dp,nums,0);
        return ans;
    }
}