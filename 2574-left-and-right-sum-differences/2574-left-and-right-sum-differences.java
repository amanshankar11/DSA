class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left=new int[nums.length];
        int[] right =new int[nums.length];
        int[] ans=new int[nums.length];
        int sum1=0;
        int sum2=0;
        left[0]=0;
        for(int i=1;i<nums.length;i++){
            sum1+=nums[i-1];
            left[i]=sum1;
        }
        right[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            sum2+=nums[i+1];
            right[i]=sum2;
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(left[i]-right[i]);
        }
        return ans;
    }
}