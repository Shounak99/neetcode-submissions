class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            max=Math.max(piles[i],max);
        }
        int beg=1;
        int end=max;
        int ans=Integer.MAX_VALUE;
        while(beg<=end){
            int mid=beg+(end-beg)/2;
            if(isValid(mid,h,piles)){
                ans=mid;
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int rate,int h,int[] piles){
        int hours=0;
        int i=0;
        while(i<piles.length){
            if(piles[i]<=rate){
                hours++;
            }
            else{
                if(piles[i]%rate==0){
                    hours+=(piles[i]/rate);
                }
                else{
                    hours+=(piles[i]/rate)+1;
                }
            }
            i++;
        }
        return hours<=h;
    }
}
