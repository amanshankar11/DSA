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
        int count=0;
        for(int[] rows:mat){
            int sum=helper(0,mat[0].length,rows);
            pq.offer(new int[]{sum,count});
            count++;
        }
        int[] result=new int[k];

        for(int i=0;i<k;i++) {
            result[i]=pq.poll()[1];
        }
        return result;
    }
}