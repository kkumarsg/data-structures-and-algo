package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class PairwiseSwap {

    /*
        method 1
            swap the data itself and you're done.

        method 2
            swap the pointers.
            * In this method while swapping Xi, We've access successfully swapped the elements till Xi-1
            * And we've access to Xi-1 pointer.

            taking it from there..
            prev -> (Xi-1)
            curr -> Xi

            prev.next = curr.next;
            prev = curr;  (making my prev ready for next iteration)
            Node next = curr.next.next;
            curr.next.next = curr; //swapping happens.
            curr = next;

        method 3
            re-use the code of reverse in groups of size k. here size = 2;
     */

    public static Node pairWiseSwap(Node head){

        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        while(curr!=null && curr.next!=null){

            prev.next = curr.next;
            prev = curr;

            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }

        prev.next = curr;
        return head;
    }
}
