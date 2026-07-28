class Solution {
    private int countDist(int[] nums,int mid){
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            while(nums[right]-nums[left]>mid){
                left++;
            }
            count+=right-left;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int smallDist=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countDist(nums,mid)>=k){
                smallDist=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return smallDist;
    }
}