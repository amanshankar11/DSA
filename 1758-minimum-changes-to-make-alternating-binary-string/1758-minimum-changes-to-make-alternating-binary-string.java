class Solution {
    public int minOperations(String s) {
        int diff1=0;
        int diff2=0;
        for(int i=0;i<s.length();i++){
            char ch1=(i%2==0)?'0':'1';
            char ch2=(i%2==0)?'1':'0';

            if(ch1!=s.charAt(i))diff1++;
            if(ch2!=s.charAt(i))diff2++;
        }
        return Math.min(diff1,diff2);
    }
}