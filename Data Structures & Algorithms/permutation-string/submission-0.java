class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ws=0;
        int we=0;
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }
        while(we<s2.length()){
            char ce=s2.charAt(we);
            freq2[ce-'a']++;
            if(we-ws+1==s1.length()){
                if(checkFreqEquals(freq1,freq2)){
                    return true;
                }
                char cs=s2.charAt(ws);
                freq2[cs-'a']--;
                ws++;
            }
            we++;
        }
        return false;
    }
    public boolean checkFreqEquals(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}
