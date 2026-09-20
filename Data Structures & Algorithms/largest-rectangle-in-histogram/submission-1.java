class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> lhs=new Stack<>();
        Stack<Integer> rhs=new Stack<>();
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!lhs.isEmpty() && heights[lhs.peek()]>=heights[i]){
                lhs.pop();
            }
            if(lhs.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=lhs.peek();
            }
            lhs.add(i);
        } 
        for(int i=heights.length-1;i>=0;i--){
            while(!rhs.isEmpty() && heights[rhs.peek()]>=heights[i]){
                rhs.pop();
            }
            if(rhs.isEmpty()){
                right[i]=heights.length;
            }
            else{
                right[i]=rhs.peek();
            }
            rhs.add(i);
        } 
        int max=0;
        for(int i=0;i<heights.length;i++){
            
            max=Math.max((right[i]-1-(left[i]+1)+1)*heights[i],max);
        }
        return max;
    }
}
