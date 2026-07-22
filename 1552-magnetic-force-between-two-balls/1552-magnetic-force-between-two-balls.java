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
        Arrays.sort(position);
        int high=position[position.length-1]-position[0];
        int low=1;
        int ans=low;
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