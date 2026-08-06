class Solution {
    private boolean isValid(int n,int t){
        int prod=1;
        while(n>0){
            int digit=n%10;
            prod=prod*digit;
            n/=10;
        }
        return prod%t==0?true:false;
    }
    public int smallestNumber(int n, int t) {
        while(!isValid(n,t)){
            n++;
        }
        return n;
    }
}