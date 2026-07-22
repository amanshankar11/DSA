class Solution {
    public boolean isValid(int[] nums,int days,int mid){
        int d=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                d++;
                sum=nums[i];
            }
        }
        return d<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=weights[0];
        int high=weights[0];
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        int ans=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(weights,days,mid)){
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