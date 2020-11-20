package linkedlists.general;
import linkedlists.singlylinkedlists.Node;

public class SortLinkedListMergeSort {

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(8);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        Node sorted = mergeSort(n1);
        System.out.println("hi");
    }


    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node firstHalf = head;
        Node secondHalf = findMiddle(head);
        Node secondHalfActual = secondHalf.next;
        secondHalf.next = null;
        firstHalf = mergeSort(firstHalf);
        secondHalfActual = mergeSort(secondHalfActual);
        return combineSortedList(firstHalf, secondHalfActual);
    }

    static Node combineSortedList(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node headResultant = null;
        Node c1 = headA;
        Node c2 = headB;

        if(c1==null){
            return c2;
        }
        else if(c2==null){
            return c1;
        }
        if(c1.data<=c2.data){
            headResultant = c1;
            c1 = c1.next;
        }
        else{
            headResultant = c2;
            c2 = c2.next;
        }
        Node c3 = headResultant;
        while(c1!=null && c2!=null){
            if(c1.data<=c2.data){
                c3.next = c1;
                c1 = c1.next;
            }
            else {
                c3.next = c2;
                c2 = c2.next;
            }
            c3 = c3.next;
        }
        if(c1==null && c2!=null){
            c3.next = c2;
        }
        if(c2==null && c1!=null){
            c3.next = c1;
        }
        return headResultant;
    }

    public static Node findMiddle(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
