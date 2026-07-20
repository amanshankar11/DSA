class Solution {

    public int firstOccurence(int target,int low,int high,int[] arr){
        if(low>high){
            return -1;
        }

        int mid=low+(high-low)/2;

        if(arr[mid]==target){
            int left=firstOccurence(target,low,mid-1,arr);
            return left==-1?mid:left;
        }
        else if(arr[mid]<target){
           return firstOccurence(target,mid+1,high,arr);
        }
        else{
            return firstOccurence(target,low,mid-1,arr);
        }
    }
    public int lastOccurrence(int target,int low,int high,int[] arr) {
    if (low>high){
        return -1;
    }
    int mid=low+(high-low)/2;

    if (arr[mid]==target) {
        int right=lastOccurrence(target,mid+1,high,arr);
        return right==-1?mid:right;
    }

    if (arr[mid]<target){
        return lastOccurrence(target,mid+1,high,arr);
    }
    else{
        return lastOccurrence(target,low,mid-1,arr);
    }
}
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        if(nums.length==1 && target==nums[0]){
            Arrays.fill(res,0);
            return res;
        }
        res[0]=-1;
        res[1]=-1;
        int low=0;
        int high=nums.length-1;
        res[0]=firstOccurence(target,0,nums.length-1,nums);
        res[1]=lastOccurrence(target,0,nums.length-1,nums);
        return res;
    }
}