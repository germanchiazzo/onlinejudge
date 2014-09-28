/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//{5->3}
// 1,2
//1->2->3->4->...

public class Solution {
    
    //Time: O(n)
    //Space Complexity: O(1)
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null || m == n){
            return head;
        }
        //add an aditional node to avoid bugs and clarify the code
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        head = preHead;
    
        ListNode mNode = head;//a pointer to the node before ListRev
        //Get left list
        for(int i=1;i<m;i++){
            mNode = mNode.next;
        }
        ListNode nNode = head;//a pointer to the last node of ListRev before reverse it
        for(int i = 1;i<=n;i++){
            nNode = nNode.next;
        }
        //Get remaining list
        ListNode remaining = nNode.next;
        //Cut ListRev (the list to reverse) at the end to reverse it
        nNode.next = null;
        //Concatenate (LeftList -> ListRev -> RemainingList)
        mNode.next = reverseLinkedList(mNode.next, remaining);
        
        return head.next;    
    }
    // 1<- <-p->c
    // 1<-2->3
    //{1->2->3}
    public ListNode reverseLinkedList(ListNode head, ListNode remaining){
        if(head == null || head.next == null)
            return head;
        //get second element
        ListNode snd = head.next;
        //get trd element
        ListNode trd = snd.next;
        //swap 2nd with 1st
        snd.next = head;
        head.next = remaining;
        if(trd == null){
            return snd;
        }
        //rename snd to previous
        ListNode previous = snd;
        //rename trd to current
        ListNode current = trd;
        //swap current with previous until current is null
        while(current!=null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}