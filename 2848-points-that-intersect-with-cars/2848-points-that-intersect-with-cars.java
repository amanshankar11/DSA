class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] arr=new boolean[101];
        for(int i=0;i<nums.size();i++){
            int start=nums.get(i).get(0);
            int end=nums.get(i).get(1);
            for(int j=start;j<=end;j++){
                arr[j]=true;
            }
        }
        int ans=0;
        for(boolean i:arr){
            if(i) ans++;
        }
        return ans;
    }
}