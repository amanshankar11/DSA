class Solution {
    public int helper(int low,int high,int[] nums){
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]==1){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1] - b[1];}
        );
        for(int i=0;i<mat.length;i++){
            int sum=helper(0,mat[0].length,mat[i]);
            pq.offer(new int[]{sum,i});
        }
        int[] result=new int[k];

        for(int i=0;i<k;i++) {
            result[i]=pq.poll()[1];
        }
        return result;
    }
}