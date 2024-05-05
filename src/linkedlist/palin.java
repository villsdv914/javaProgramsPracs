package linkedlist;


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
class palin {
    public static boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode newnode = new ListNode();
        newnode = head;
        return check(head,newnode) != null;
    }

    public static ListNode check(ListNode head, ListNode frst ){
        if(head == null){
            return frst;
        }
        ListNode newnode = new ListNode();
        newnode = check( head.next, frst);
        if(head.val == newnode.val){
            if(newnode.next != null){
                return newnode.next;
            }
                return newnode ;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(2);
//        l1.next.next.next = new ListNode(1);

//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        System.out.println(isPalindrome(l1));
        System.out.println(new String());

    }


}