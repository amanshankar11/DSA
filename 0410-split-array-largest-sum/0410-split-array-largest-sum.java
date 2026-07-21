class Solution {
    public boolean isValid(int[] arr,int k,int mid){
        int subArrays=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mid){
                subArrays++;
                sum=arr[i];
            }
        }
        return subArrays<=k;
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