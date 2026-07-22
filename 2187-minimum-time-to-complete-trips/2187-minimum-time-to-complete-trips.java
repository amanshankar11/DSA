class Solution {
    public boolean isValid(int[] nums,int trips,long mid){
        long time=0;
        for(int i=0;i<nums.length;i++){
            time+=mid/nums[i];
        }
        if(time>=trips){
            return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long low=time[0];
        for(int i=0;i<time.length;i++){
            low=Math.min(low,time[i]);
        }
        long high=low*totalTrips;
        long ans=low;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(isValid(time,totalTrips,mid)){
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