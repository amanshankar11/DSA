class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int overall=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                int count=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    count++;
                }
                if(count%2!=0)overall+=sum;
            }
        }
        return overall;
    }
}