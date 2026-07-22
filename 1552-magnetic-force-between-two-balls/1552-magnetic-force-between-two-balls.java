class Solution {
    public boolean isValid(int[] nums,int m,int mid){
        int balls=1;
        int last=nums[0];
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-last)>=mid){
                balls++;
                last=nums[i];
            }
        }
        return balls>=m;

    }
    public int maxDistance(int[] position, int m) {
        int low=position[0];
        int high=position[0];
        for(int i=0;i<position.length;i++){
            low=Math.min(low,position[i]);
            high=Math.max(high,position[i]);
        }
        int diff=high-low;
        high=diff;
        low=1;
        int ans=low;
        Arrays.sort(position);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(position,m,mid)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}