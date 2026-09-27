class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new Integer[word1.length()][word2.length()];
        return helper(word1,word2,word1.length(),word2.length());
    }
    public int helper(String word1,String word2,int n,int m){
        if(n==0 && m==0){
            return 0;
        }
        if(n==0 && m>0){
            return m;
        }
        if(m==0 && n>0){
            return n;
        }
        if(dp[n-1][m-1]!=null){
            return dp[n-1][m-1];
        }
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return dp[n-1][m-1]=helper(word1,word2,n-1,m-1);
        }
        int ans1=helper(word1,word2,n-1,m);
        int ans2=helper(word1,word2,n-1,m-1);
        int ans3=helper(word1,word2,n,m-1);
        return dp[n-1][m-1]=Math.min(ans1,Math.min(ans2,ans3))+1;
    }
}
