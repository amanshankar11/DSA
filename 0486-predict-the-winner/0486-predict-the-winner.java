class Solution {
    private int helper(int[] nums,int i,int j){
        if(i==j) return nums[i];
        int left=nums[i]-helper(nums,i+1,j);
        int right=nums[j]-helper(nums,i,j-1);
        return Math.max(left,right);
    }
    public boolean predictTheWinner(int[] nums) {
        int diff=helper(nums,0,nums.length-1);
        return diff>=0;
    }
}