class LRUCache {
    private int capacity;
    private HashMap<Integer,ListNode> map=null;
    private ListNodeOperation ops=null;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.ops=new ListNodeOperation();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node=ops.removeNode(map.get(key));
            ops.makeMRU(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // first get Node
            ListNode node=ops.removeNode(map.get(key));
            // update the value in node
            node.value=value;
            // MRU
            ops.makeMRU(node);
            return;
        }
        if(map.size()>=capacity){
            // remove LRU 
            ListNode node=ops.removeLRU();
            // remove Entry from the map
            map.remove(node.key);
        }
        // create a new Node with key and value
        ListNode nnode=new ListNode(key,value);
        // add entry to the map
        map.put(key,nnode);
        // Make this node as MRU
        ops.makeMRU(nnode);
    }
}

class ListNodeOperation{
    private ListNode head=new ListNode(-1,-1);
    private ListNode tail=new ListNode(-1,-1);

    public ListNodeOperation(){
        head.next=tail;
        tail.prev=head;
    }

    public void makeMRU(ListNode node){
        node.prev=head;
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
    }

    public ListNode removeNode(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;
        return node;
    }

    public ListNode removeLRU(){
        return removeNode(tail.prev);
    }

}

class ListNode{
    public ListNode prev=null;
    public ListNode next=null;
    public int key;
    public int value;
    
    public ListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */