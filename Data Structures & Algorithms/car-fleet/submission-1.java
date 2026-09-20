

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices=new Integer[position.length];
        for(int i=0;i<position.length;i++){
            indices[i]=i;
        }
       Arrays.sort(indices, (a, b) -> 
            Integer.compare(position[b], position[a])
        );
        int fleet=1;
        double timeOfLastFleet=(double) (target-position[indices[0]])/(double) speed[indices[0]];
        for(int i=1;i<position.length;i++){
            int currSpeed=speed[indices[i]];
            int currPosition=position[indices[i]];
            double time=(double) (target-currPosition)/(double) currSpeed;
            if(time>timeOfLastFleet){
                fleet++;
                timeOfLastFleet=time;
            }
        }
        return fleet;
       
    }
}
