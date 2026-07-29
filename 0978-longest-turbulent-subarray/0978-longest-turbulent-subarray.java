class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left=0;
        int ans=1;
        for(int right=1;right<arr.length;right++){
            if(arr[right]==arr[right-1]){
                left=right;
            }
            else if(right>=2){
                int curr;
                if(arr[right]>arr[right-1]){
                    curr=1;
                }else if(arr[right]<arr[right-1]){
                    curr=-1;
                }else{
                    curr=0;
                }

                int prev;
                if(arr[right-1]>arr[right-2]){
                    prev=1;
                }else if(arr[right-1]<arr[right-2]){
                    prev=-1;
                }else{
                    prev=0;
                }

                if(prev==curr){
                    left=right-1;
                }
            }
            ans=Math.max(ans,right-left+1);
        }
        // int less = 1;int great = 1;int res = 1;
        // for(int i=1;i<arr.length;i++){
        //     if(arr[i]>arr[i-1]){
        //         great = less+1;
        //         less = 1;
        //     }else if(arr[i]<arr[i-1]){
        //         less= great+1;
        //         great = 1;
        //     }else{
        //         less = great = 1;
        //     }
        //     res = Math.max(res, Math.max(less, great));
        // }
        return ans;
    }
}