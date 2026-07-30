class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i:cardPoints) sum+=i;
        if(cardPoints.length==k){
            return sum;
        }
        int miniSum=0;
        for(int i=0;i<cardPoints.length-k;i++){
            miniSum+=cardPoints[i];
        }

        int currSum=miniSum;
        for(int right=cardPoints.length-k;right<cardPoints.length;right++){
            currSum+=cardPoints[right];
            currSum-=cardPoints[right-(cardPoints.length-k)];
            miniSum=Math.min(miniSum,currSum);
        }
        return sum-miniSum;
    }
}