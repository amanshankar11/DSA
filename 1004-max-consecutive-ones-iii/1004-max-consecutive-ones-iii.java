class Solution {
    public int longestOnes(int[] nums, int k) {
        int dupK=0;
        int left=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=1;

            if(nums[right]==0) dupK++;

            while(dupK>k){
                if(nums[left]==0) dupK--;
                sum-=1;
                left++;
            }

            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}