class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(freq1[i]>0){
            matches++;
            }
        }
        int we=0;
        int ws=0;
        
        while(we<s2.length()){
            char ce=s2.charAt(we);
            freq2[ce-'a']++;
            if(freq2[ce-'a']>0 && freq2[ce-'a']==freq1[ce-'a']){
                matches--;
            }
            if(we-ws+1==s1.length()){
                if(matches==0){
                    return true;
                }
                else{
                    char cs=s2.charAt(ws);
                    if(freq2[cs-'a']>0 && freq2[cs-'a']==freq1[cs-'a']){
                        matches++;
                    }
                    freq2[cs-'a']--;
                    ws++;
                }
            }
            we++;

        }
        return false;
    }
    public boolean freqMatch(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}
