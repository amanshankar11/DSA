class Solution {
    private boolean isValid(int[] monster,long str,long[] bonus){
        for(int i=0;i<monster.length;i++){
            if(str+bonus[i]<monster[i])return false;
            str-=monster[i];
            if(str<0)str=0;
        }
        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long[] power=new long[monsters.length+1];

        for(int[] boost:boosts){
            int l=boost[0];
            int r=boost[1];
            int v=boost[2];
            power[l]+=v;
            power[r+1]-=v;
        }

        long[] bonus=new long[monsters.length];
        long run=0;
        long sum=0;
        for(int i=0;i<monsters.length;i++){
            run+=power[i];
            bonus[i]=run;
            sum+=monsters[i];
        }
        long low=0;
        long high=sum;

        while(low<=high){
            long mid=low+(high-low)/2;
            if(isValid(monsters,mid,bonus)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}