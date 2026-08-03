class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int len=0;
        for(int[] book:bookings){
            if(len<book[1]) len=book[1];
        }
        int[] prefix=new int[n];
        for(int[] book:bookings){
            for(int i=book[0];i<=book[1];i++){
                prefix[i-1]+=book[2];
            }
        }
        return prefix;
    }
}