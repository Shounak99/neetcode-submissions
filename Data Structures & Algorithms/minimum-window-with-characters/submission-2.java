class Solution {
    public String minWindow(String s, String t) {
        int[] freq1=new int[256];
        int[] freq2=new int[256];
        for(char c:t.toCharArray()){
            freq1[c-'A']++;
        }
        int matches=0;
        for(int i=0;i<256;i++){
            if(freq1[i]>=1){
                matches++;
            }
        }
        int len=Integer.MAX_VALUE;
        String res="";
        int we=0;
        int ws=0;
        while(we<s.length()){
            char ce=s.charAt(we);
            freq2[ce-'A']++;
            if(freq1[ce-'A']>=1 && freq1[ce-'A']==freq2[ce-'A']){
                matches--;
            }
            while(matches==0){
                char cs=s.charAt(ws);
                if(len>we-ws+1){
                    len=we-ws+1;
                    res=s.substring(ws,we+1);
                }
               
                if(freq2[cs-'A']>=1){
                    if(freq2[cs-'A']==freq1[cs-'A']){
                        matches++;
                    }
                    freq2[cs-'A']--;
                }
                ws++;
            }
            we++;
        }
        return res;
    }
}
