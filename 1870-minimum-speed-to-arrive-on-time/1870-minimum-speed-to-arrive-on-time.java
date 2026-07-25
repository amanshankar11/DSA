class Solution {
    public boolean isValid(int[] nums,double hour,int mid){
        double timeTook=0;
        for(int i=0;i<nums.length;i++){
            double time=(double)nums[i]/mid;
            if(i!=nums.length-1){
                timeTook+=Math.ceil(time);
            }
            else{
                timeTook+=time;
            }
        }
        return timeTook<=hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=dist[0];
        int high=dist[0];
        for(int i=1;i<dist.length;i++){
            low=Math.min(low,dist[i]);
            high=Math.max(high,dist[i]);
            // high+=dist[i];
        }
        high=10000000;
        low=1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(dist,hour,mid)){
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