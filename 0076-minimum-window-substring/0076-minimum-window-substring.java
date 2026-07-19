class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        String res="";
        Map<Character,Integer> tmap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        int start=0;
        int formed=0;
        int startIndex=0;
        int required=tmap.size();
        int minLen=Integer.MAX_VALUE;
        Map<Character,Integer> window=new HashMap<>();
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if (tmap.containsKey(ch) &&
                window.get(ch).intValue() == tmap.get(ch).intValue()) {

                formed++;
            }

            while(formed==required){
                 if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }
                char left = s.charAt(start);
                window.put(left, window.get(left) - 1);

                 if (tmap.containsKey(left) &&
                    window.get(left) < tmap.get(left)) {

                    formed--;
                }
                start++;
            }
        }
         return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}