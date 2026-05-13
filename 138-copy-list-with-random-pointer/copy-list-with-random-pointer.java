/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node prev=null;
        Node temp=head;
        HashMap<Node,Node> map=new HashMap<>();
        while(temp!=null){
            Node nn=new Node(temp.val);
            if(prev!=null){
                prev.next=nn;
            }
            prev=nn;
            map.put(temp,nn);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                map.get(temp).random=map.get(temp.random);
            }
            temp=temp.next;
        }
        return map.get(head);
    }
}