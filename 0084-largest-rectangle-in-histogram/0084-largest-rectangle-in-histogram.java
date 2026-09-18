class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            int curr= (heights.length==i)?0:heights[i];

            while(!st.isEmpty() && heights[st.peek()]>curr){
                int h=heights[st.pop()];
                int w;
                if(st.isEmpty()){
                    w=i;
                }
                else{
                    w=i-st.peek()-1;
                }
                maxArea=Math.max(maxArea,h*w);
            }
            st.push(i);
        }
        return maxArea;
    }
}