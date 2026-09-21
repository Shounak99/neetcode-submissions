class TimeMap {
    Map<String,List<Pair<String,Integer>>> map;
    public TimeMap() {
        map=new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair<String,Integer>> list=map.get(key);
        int l=0;
        int r=list.size()-1;
        String ans="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid).getValue()<=timestamp){
                ans=list.get(mid).getKey();
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}
