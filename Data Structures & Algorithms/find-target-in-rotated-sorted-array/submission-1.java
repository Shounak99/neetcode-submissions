class Solution {
    public int search(int[] nums, int target) {
        if(nums[0]<nums[nums.length-1]){
            return BS(0,nums.length-1,nums,target);
        }
        int mid=findPivot(nums);
        System.out.println(mid);
        if(mid>=0 && mid<=nums.length){
        if(target>=nums[0] && target<=nums[mid]){
            return BS(0,mid,nums,target);
        }
        else{
            return BS(mid+1,nums.length-1,nums,target);
        }   
        }
        return -1;
    }
    public int findPivot(int[] nums){
        int l=0;
        int r=nums.length-1;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=nums[0]){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public int BS(int l,int r,int[] nums,int target){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
