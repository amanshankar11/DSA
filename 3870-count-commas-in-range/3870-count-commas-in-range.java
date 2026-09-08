class Solution {
    private int coma(int n){
        if(n<=4)return 0;
        String num=String.valueOf(n);
        int commas=num.length()/4;
        return commas;
    }
    public int countCommas(int n) {
        int commas=0;
        for(int i=1;i<=n;i++){
            commas+=coma(i);
        }
        return commas;
    }
}