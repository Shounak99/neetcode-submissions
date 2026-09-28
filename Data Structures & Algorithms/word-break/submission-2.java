class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        Set<String> set=new HashSet<>(wordDict);
        return helper(s,set,0,0);
    }
    public boolean helper(String s,Set<String> set,int i,int count){

        if(i>=s.length()){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        
        for(int j=i;j<s.length();j++){
            if(set.contains(s.substring(i,j+1))){
                dp[i]=helper(s,set,j+1,count+1);
                 if(dp[i]){
                    return true;
                 }
            }
        }
        return dp[i]=false;
    }
}
