class Solution {
    private int sum(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            sum+=digit;
            num/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int minIndex=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum(nums[i])==i){
                if(minIndex>i){
                    minIndex=i;
                }
            }
        }
        return (minIndex==Integer.MAX_VALUE)?-1:minIndex;
    }
}