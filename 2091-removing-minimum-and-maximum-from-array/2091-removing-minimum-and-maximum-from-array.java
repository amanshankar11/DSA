class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        if(nums.length==2) return 2;
        int n=nums.length;
        int minIndex=0,maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[maxIndex]<nums[i]){
                maxIndex=i;
            }
            if(nums[minIndex]>nums[i]){
                minIndex=i;
            }
        }
        int left=Math.max(minIndex,maxIndex)+1;
        int right=n-Math.min(minIndex,maxIndex);
        int both=Math.min(minIndex+1 + n-maxIndex,maxIndex+1 + n-minIndex);

        return Math.min(left,Math.min(right,both));
    }
}