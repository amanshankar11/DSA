class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] arr=new int[102];
        for(int i=0;i<nums.size();i++){
            int start=nums.get(i).get(0);
            int end=nums.get(i).get(1);
            arr[start]+=1;
            arr[end+1]-=1;
        }
        int ans=0;
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            if(arr[i]!=0) ans++;
        }
        return ans;
    }
}