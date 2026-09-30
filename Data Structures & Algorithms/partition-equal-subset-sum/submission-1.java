class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
            int sum=0;
            for(int num:nums){
                sum+=num;
            }
            if(sum%2!=0){
                return false;
            }
            dp=new Boolean[nums.length][sum+1];
         return helper(nums,0,sum/2);
    }
    public boolean helper(int[] nums,int i,int sum){
        if(sum==0){
            return true;
        }
        if(sum<0||(sum>0 && i>=nums.length)){
            return false;
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        return dp[i][sum]=helper(nums,i+1,sum-nums[i])||helper(nums,i+1,sum);
    }
}
