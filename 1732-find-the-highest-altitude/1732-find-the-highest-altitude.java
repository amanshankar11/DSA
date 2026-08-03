class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix=new int[gain.length];
        int max=0;
        prefix[0]=gain[0];
        max=Math.max(max,prefix[0]);
        for(int i=1;i<gain.length;i++){
            prefix[i]=prefix[i-1]+gain[i];
            max=Math.max(max,prefix[i]);
        }
        return max;
    }
}