class Solution {
    public boolean isValid(int[] nums,int k,int mid){
        int sum=0;
        int subArray=1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                subArray++;
                sum=nums[i];
            }
        }
        return subArray<=k;
    }
    public int splitArray(int[] nums, int k) {
        int low=nums[0];
        int high=nums[0];
        for(int i=1;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        int ans=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}