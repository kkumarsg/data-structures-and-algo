package linkedlists.circularlinkedlists;

import linkedlists.singlylinkedlists.Node;

public class DeleteHead {

    public Node deleteHeadNaive(Node head){
        if(head==null || head.getNext()==null){
            return null;
        }
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(head.getNext());
        return head.getNext();
    }

    public Node deleteHeadEfficient(Node head){
        if(head==null || head.getNext()==null){
            return null;
        }
        head.setData(head.getNext().getData());
        head.setNext(head.getNext().getNext());
        return head;
    }
}
