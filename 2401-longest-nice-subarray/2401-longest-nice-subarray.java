class Solution {
    public int longestNiceSubarray(int[] nums) {
        int length=0;
        int left=0;
        int mask=0;
        for(int right=0;right<nums.length;right++){
            while((mask&nums[right])!=0) {
                mask^=nums[left];
                left++;
            }

            mask|=nums[right];

            length=Math.max(length,right-left+1);
        }
        return length;
    }
}