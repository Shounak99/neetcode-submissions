class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Pair<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,new Pair<>(i,i));
            }
            else{
                int start=map.get(c).getKey();
                map.put(c,new Pair<>(start,i));
            }
        }
        List<int[]> intervals=new ArrayList<>();
        for(Pair<Integer,Integer> interval:map.values()){
            intervals.add(new int[]{interval.getKey(),interval.getValue()});
        }
        Collections.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> mergedIntervals=new ArrayList<>();
        mergedIntervals.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            int[] prev=mergedIntervals.get(mergedIntervals.size()-1);
            int[] curr=intervals.get(i);
            if(prev[1]>=curr[0]){
                prev[1]=Math.max(prev[1],curr[1]);
            }
            else{
                mergedIntervals.add(curr);
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int[] interval:mergedIntervals){
            result.add(interval[1]-interval[0]+1);
        }
        return result;
    }
}
