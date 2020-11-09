package linkedlists.circularlinkedlists;

import linkedlists.singlylinkedlists.Node;

public class Traversing {

    public static void traverseCircularLL(Node head){
        if (head==null) {
            return ;
        }
        System.out.print(head.getData()+"->");
        Node iterator = head.getNext();
        while (iterator != head) {
            System.out.print(iterator.getData()+"->");
            iterator = iterator.getNext();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(15);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n1);
        traverseCircularLL(n1);
    }
}
