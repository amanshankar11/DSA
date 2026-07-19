class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        boolean[] visited=new boolean[26];
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            freq[c-'a']--;

            if(visited[c-'a']) continue;
            while(!stack.isEmpty() && stack.peek()>c && freq[stack.peek()-'a'] > 0){
                visited[stack.pop() -'a']=false;
            }
            stack.push(c);
            visited[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }

        return sb.toString();
    }
}