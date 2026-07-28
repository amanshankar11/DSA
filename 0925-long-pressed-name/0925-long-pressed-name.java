class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int left=0;
        int right=0;
        while(left<name.length()){
            char ch=name.charAt(left);
            int count1=1,count2=1;
            if(right>=typed.length() || typed.charAt(right)!=ch) return false;
            while(left+1<name.length() && name.charAt(left+1)==ch){
                count1++;
                left++;
            }
            while(right+1<typed.length() && typed.charAt(right+1)==ch){
                count2++;
                right++;
            }
            if(count1>count2){
                return false;
            }
            left++;
            right++;
        }
        return right==typed.length();
    }
}