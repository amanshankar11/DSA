class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int overall=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                int len=j-i+1;
                if(len%2!=0){
                    for(int k=i;k<=j;k++){
                        sum+=arr[k];
                    }
                }
                overall+=sum;
            }
        }
        return overall;
    }
}