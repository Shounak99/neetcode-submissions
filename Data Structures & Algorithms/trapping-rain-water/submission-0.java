class Solution {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        int[] rightMax=new  int[height.length];
        int currMax=0;
        for(int i=0;i<height.length;i++){
            if(height[currMax]<=height[i]){
                currMax=i;
                
            }
            leftMax[i]=currMax;
        }
        currMax=height.length-1;
        for(int i=height.length-1;i>=0;i--){
            if(height[currMax]<=height[i]){
                currMax=i;
            }
            rightMax[i]=currMax;
        }
    
        int water=0;
        for(int i=0;i<height.length;i++){
           
            water+=Math.min(height[leftMax[i]],height[rightMax[i]])-height[i];
            // System.out.print(water);
            //  System.out.println("heights:"+height[leftMax[i]]+" "+height[rightMax[i]]);
        }
        return water;
    }
}
