class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] arr=new int[s.length()];
        for(int i=0;i<arr.length;i++){
            char ch=t.charAt(i);
            arr[i]=Math.abs(ch-s.charAt(i));
        }
        int left=0;
        int cost=0;
        int maxLen=Integer.MIN_VALUE;
        for(int right=0;right<arr.length;right++){
            cost+=arr[right];
            while(cost>maxCost){
                cost-=arr[left];
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}