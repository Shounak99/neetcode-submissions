class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!pq.isEmpty() && nums[pq.peek()]<=nums[i]){
                pq.poll();
            }
            pq.add(i);
        }
        res[0]=nums[pq.peek()];
        int idx=1;
        for(int i=k;i<nums.length;i++){
            while(!pq.isEmpty() && pq.peek()<=i-k){
                pq.poll();
            }
            while(!pq.isEmpty() && nums[pq.peek()]<=nums[i]){
                pq.poll();
            }
            pq.add(i);
            res[idx++]=nums[pq.peek()];
        }
        return res;
    }
}
