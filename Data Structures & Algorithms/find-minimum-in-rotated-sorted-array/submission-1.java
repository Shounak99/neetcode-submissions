class Solution {
    public int findMin(int[] nums) {
        int beg=0;
        int end=nums.length-1;
        int ans=nums[0];
        while(beg<=end){
            if(nums[beg]<nums[end]){
                ans=Math.min(ans,nums[beg]);
                return ans;
            }
            int mid=beg+(end-beg)/2;
            ans=Math.min(ans,nums[mid]);
            if(nums[mid]>=nums[beg]){
                beg=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}
