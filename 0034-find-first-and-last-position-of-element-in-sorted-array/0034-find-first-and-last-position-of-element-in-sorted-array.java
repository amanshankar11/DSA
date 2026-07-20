class Solution {

    public int leftOccurence(int target,int low,int high,int[] nums){
        if(low>high) return -1;

        int mid=low+(high-low)/2;


        if(nums[mid]==target){
            int left=leftOccurence(target,low,mid-1,nums);
            if(left==-1) return mid;
            return left;
        }
        else if(nums[mid]>target){
            return leftOccurence(target,low,mid-1,nums);
        }
            return leftOccurence(target,mid+1,high,nums);
    }
    public int rightOccurence(int target,int low,int high,int[] nums){
        if(low>high) return -1;

        int mid=low+(high-low)/2;

        if(nums[mid]==target){
            int right=rightOccurence(target,mid+1,high,nums);
            if(right==-1) return mid;
            return right;
        }
        else if(nums[mid]>target){
            return rightOccurence(target,low,mid-1,nums);
        }
            return rightOccurence(target,mid+1,high,nums);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=leftOccurence(target,0,nums.length-1,nums);
        ans[1]=rightOccurence(target,0,nums.length-1,nums);
        return ans;
    }
}