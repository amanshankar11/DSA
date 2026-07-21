class Solution {

    public boolean isValid(int[] piles,int h,int mid){
       int hour=0;
        for(int i=0;i<piles.length;i++){
            hour+=(piles[i]/mid);
            if(piles[i]%mid>0) hour++;
        }
        if(hour<0) return false;
        return hour<=h;   
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(piles,h,mid)){
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


