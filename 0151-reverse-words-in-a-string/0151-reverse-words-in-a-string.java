class Solution {
//     private String helper(char[] s){
//         int low=0;
//         int high=s.length-1;
//         while(low<high){
//             char t=s[low];
//             s[low]=s[high];
//             s[high]=t;
//             low++;
//             high--;
//         }
//         return new String(s);
//     }
    public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        String res=sb.toString().trim();
        return res;
    }
}