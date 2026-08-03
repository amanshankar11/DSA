class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix=new int[1001];
        for(int[] trip:trips){
            for(int i=trip[1];i<trip[2];i++){
                prefix[i]+=trip[0];
            }
        }

        for(int i=0;i<prefix.length;i++){
            if(prefix[i]>capacity) return false;
        }
        return true;
    }
}