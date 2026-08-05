class Solution {
    private int helper(int[][] dp,String s1,String s2,int i,int j){
        // if(i>=s1.length() || j>=s2.length()) return 0;
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return helper(dp,s1,s2,i+1,j+1);
        }
        int delete=1+helper(dp,s1,s2,i+1,j);
        int replace=1+helper(dp,s1,s2,i+1,j+1);
        int insert=1+helper(dp,s1,s2,i,j+1);

        return dp[i][j]=Math.min(delete,Math.min(replace,insert));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        int min=helper(dp,word1,word2,0,0);
        return min;
    }
}