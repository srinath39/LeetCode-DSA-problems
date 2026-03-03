/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int m=getLength(l1);
        int n=getLength(l2);
        ListNode dummy=new ListNode();
        ListNode head1,head2;
        head1=dummy;
        if(m<=n){
            dummy.next=l2;
            head2=l1;
        }else{
            dummy.next=l1;
            head2=l2;
        }
        int c=0;
        while(head2!=null){
            int val=head1.next.val+head2.val+c;
            if(val>9){
                head1.next.val=val%10;
                c=1;
            }else{
                head1.next.val=val;
                c=0;
            }
            head2=head2.next;
            head1=head1.next;
        }

        while(c>0 && head1.next!=null){
            int val=head1.next.val+c;
            if(val>9){
                head1.next.val=val%10;
                c=1;
            }else{
                head1.next.val=val;
                c=0;
            }
            head1=head1.next;
        }

        if(c>0){
            head1.next=new ListNode(c);
        }
        return dummy.next;
    }

    public int getLength(ListNode l){
        int len=0;
        while(l!=null){
            ++len;
            l=l.next;
        }
        return len;
    }
}