class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res=new int[code.length];
        if(k==0) return res;
        for(int i=0;i<res.length;i++){
            
            int dupK=Math.abs(k);
            int sum=0;
            int j;
            if(k>0){
                j=i+1;
                while(dupK-->0){
                    sum+=code[j%code.length];
                    j++;
                }
                res[i]=sum;
            }
            else{
                j=i-1;
                while(dupK-->0){
                    sum+=code[(j+code.length)%code.length];
                    j--;
                }
                res[i]=sum;
            }
        }
        return res;
    }
}