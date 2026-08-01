class Solution {
    public int countValidPrefixes(String s) {
        char[] str=s.toCharArray();
        int count0=0;
        int count1=0;
        int altSeq=0;
        for(int right=0;right<str.length;right++){
            if(str[right]=='0') count0++;
            else count1++;

            if(count0==count1 || count0-1==count1 || count0==count1-1){
                altSeq++;
            }
            
        }
        return altSeq;
    }
}