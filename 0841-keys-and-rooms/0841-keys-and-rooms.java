class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(visited,rooms,0);
        for(int i=1;i<visited.length;i++){
            if(visited[i]==false)return false;
        }
        return true;
    }
    private void dfs(boolean[] visited,List<List<Integer>> rooms,int from){
        visited[from]=true;
        for(int to=0;to<rooms.get(from).size();to++){
            if(!visited[rooms.get(from).get(to)]){
                dfs(visited,rooms,rooms.get(from).get(to));
            }
        }
    }
}