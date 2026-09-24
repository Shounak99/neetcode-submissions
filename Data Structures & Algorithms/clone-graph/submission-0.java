/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Queue<Node> bfs=new LinkedList<>();
        Map<Node,Node> map=new HashMap<>();
        map.put(node,new Node(node.val));
        bfs.add(node);
        while(!bfs.isEmpty()){
            int size=bfs.size();
            while(size>0){
            Node parent=bfs.poll();
            if(!map.containsKey(parent)){
                map.put(parent,new Node(parent.val));
            }
            for(Node neighbor:parent.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val));
                    bfs.add(neighbor);
                   
                }

                map.get(parent).neighbors.add(map.get(neighbor));
              }
              size--;
           }
        }
        return map.get(node);
    }
}