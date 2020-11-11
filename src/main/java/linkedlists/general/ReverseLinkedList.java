package linkedlists.general;

import linkedlists.singlylinkedlists.Node;

public class ReverseLinkedList {

    public static Node tail = null;

    public static Node reverseLinkedList(Node head){

        Node prev = null;
        Node current = head;
        while(current!=null){
            Node temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }

        return prev;
    }

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

        recursiveReverseNaive(n1);
        System.out.println("Tail");
    }

    public static Node recursiveReverseNaive(Node head){
        if(head.getNext()==null){
            tail = head;
            return head;
        }
        Node next = recursiveReverseNaive(head.getNext());
        next.setNext(head);
        head.setNext(null);
        return head;
    }

    public static Node recursiveReverseEfficient(Node prev, Node current){
        if(current==null){
            return prev;
        }
        Node next = current.getNext();
        current.setNext(prev);
        return recursiveReverseEfficient(current, next);
    }
}
