package stack;

import linkedlists.singlylinkedlists.Node;

public class LinkedListImplementationStack {

    /*
        * Approach is simple we delete the head for popping.
        * We make the current element to be added as head while pushing.
     */
    Node head;
    int size = 0;

    public void push(int ele){
        size = size+1;
        Node node = new Node(ele);
        node.next = head;
        head = node;
    }

    public void pop(){
        if(head==null){
            System.out.println("Stack is empty, try adding some elements ");
        }
        head = head.next;
        size = size-1;
    }

    public int size(){
        return size;
    }
}
