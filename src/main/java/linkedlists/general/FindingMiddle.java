package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class FindingMiddle {

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(20);
        Node n4 = new Node(15);
        Node n5 = new Node(25);
        Node n6 = new Node(30);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        findMiddleOfLinkedListEfficiently(n1);
    }

    public static void findMiddleOfLinkedListEfficiently(Node head){
        if (head!=null) {
            Node slow = head;
            Node fast = head;
            while(slow!=null && fast.getNext() !=null){
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
            System.out.println(slow.getData());
        }
    }

    public static void findMiddleOfLinkedListNaive(Node head){
        int middleIndex = findMiddleIndex(head);
        if (middleIndex!=0) {
            int k = 1;
            while(k!=middleIndex){
                head = head.getNext();
                k++;
            }
            System.out.println(head.getData());
        }
    }

    private static int findMiddleIndex(Node head) {
        if (head==null) {
            return 0;
        }
        int k = 0;
        while(head!=null){
            k++;
            head = head.getNext();
        }
        return 1+(k/2);
    }
}
