class Solution {
    public String minWindow(String s, String t) {
        int[] freq1=new int[256];
        int[] freq2=new int[256];
        int have=0;
        for(int i=0;i<t.length();i++){
            freq1[t.charAt(i)-'A']++;
        }
        int need=0;
        for(int i=0;i<freq1.length;i++){
            if(freq1[i]>=1){
                need++;
            }
        }
        int we=0;
        int ws=0;
        String result="";
        int len=s.length();
        while(we<s.length()){
            char ce=s.charAt(we);
            freq2[ce-'A']++;
            if(freq2[ce-'A']>=1 && freq2[ce-'A']==freq1[ce-'A']){
                have++;
            }
            while(have==need){
                if(len>=we-ws+1){
                    len=we-ws+1;
                    result=s.substring(ws,we+1);
                }
                char cs=s.charAt(ws);
                freq2[cs-'A']--;
                if(freq2[cs-'A']<freq1[cs-'A']){
                    have--;
                }
                ws++;
            }
            we++;
        }
        return result;
    }
}
