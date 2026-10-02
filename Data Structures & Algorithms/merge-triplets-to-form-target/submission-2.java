class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> notToBeVisited=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<triplets.length;j++){
                if(triplets[j][i]>target[i]){
                    notToBeVisited.add(j);
                }
            }
        }
        for(int i=0;i<3;i++){
            int res=Integer.MIN_VALUE;
            for(int j=0;j<triplets.length;j++){
                if(triplets[j][i]<=target[i] && !notToBeVisited.contains(j)){
                    res=Math.max(res,triplets[j][i]);
                    
                }
                else {
                    notToBeVisited.add(j);
                }
            }
            if(res!=target[i]){
                return false;
            }
        }
        return true;
    }
}
