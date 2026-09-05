class Solution {
    public int maxArea(int[] heights) {
        int lo=0;
        int hi=heights.length-1;
        int result=0;
        while(lo<hi){
            int area=Math.min(heights[lo],heights[hi])*(hi-lo);
            result=Math.max(result,area);
            if(heights[lo]<=heights[hi]){
                lo++;
            }
            else{
                hi--;
            }
        }
        return result;
    }
}
