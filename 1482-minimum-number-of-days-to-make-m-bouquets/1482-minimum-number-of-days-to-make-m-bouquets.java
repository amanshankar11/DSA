class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i]<=day) {
                flowers++;
            } else {
                bouquets+=flowers/k;
                flowers=0;
            }
        }
        bouquets+=flowers/k;
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        // if ((long) m * k > bloomDay.length)
        //     return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if (isPossible(bloomDay,m,k,mid)) {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}