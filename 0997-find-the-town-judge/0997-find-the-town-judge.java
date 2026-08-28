class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] nodes=new int[n+1];
        int res=-1;
        for(int i=0;i<trust.length;i++){
            nodes[trust[i][0]]--;
            nodes[trust[i][1]]++;
        }
        for(int i=1;i<nodes.length;i++){
            if(nodes[i]==n-1){
                res=i;
                break;
            }
        }
        return res;
    }
}