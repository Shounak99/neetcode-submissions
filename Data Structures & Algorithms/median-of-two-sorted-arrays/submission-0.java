class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int total=n+m;
        int half=total/2;
        int l=0;
        int r=m;
        while(l<=r){
            int mid=l+(r-l)/2;
            int otherMid=half-mid;
            int nums1FirstHalf=mid-1>=0?nums1[mid-1]:Integer.MIN_VALUE;
            int nums1SecondHalf=mid>=m?Integer.MAX_VALUE:nums1[mid];
            int nums2FirstHalf=otherMid-1<0?Integer.MIN_VALUE:nums2[otherMid-1];
            int nums2SecondHalf=otherMid>=n?Integer.MAX_VALUE:nums2[otherMid];
            if(nums1FirstHalf<=nums2SecondHalf && nums2FirstHalf<=nums1SecondHalf){
                if(total%2!=0){
                    return Math.min(nums1SecondHalf,nums2SecondHalf);
                }
                else{
                   return (double)(Math.max(nums1FirstHalf,nums2FirstHalf)+Math.min(nums1SecondHalf,nums2SecondHalf))/2.0;
                }
            }
            else if(nums1FirstHalf>nums2SecondHalf){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return 0.0;
    }
}
