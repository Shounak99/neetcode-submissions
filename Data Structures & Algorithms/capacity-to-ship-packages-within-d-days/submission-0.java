class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=weights[0];
        int r=0;
        for(int weight:weights){
            l=Math.max(l,weight);
            r+=weight;
        }
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(mid,weights,days)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int capacity,int[] weights,int days){
        int currDays=0;
        int i=0;
        int temp=capacity;
        while(i<weights.length){
           int j=i;
           temp=capacity;
           while(j<weights.length && temp-weights[j]>=0){
            temp-=weights[j];
            j++;
           }
           currDays++;
           i=j;
        }
        return currDays<=days;
    }
}